package com.zzsxt.lee.springboot.controller;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.zzsxt.lee.springboot.model.User;
import com.zzsxt.lee.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Long.parseLong;

/**
 * @Descriotion
 * @Company 北京尚学堂
 * @Author Seven Lee
 * @Date 2018/6/11
 * @Time 10:04
 */
@Controller
@RequestMapping(value = "/page")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/uploadForm")
    public String listUploadedFiles(){
        return "uploadForm";
    }
    @RequestMapping("/selectAllUsers")
    public String selectAllUsers(ModelMap map) {
        List<User> list = userService.selectAll();
        map.addAttribute("users",list);
        return "user_list";
    }



    @RequestMapping("/deleteById")
    public String deleteById(Long id) {
       int i =  userService.deleteByPrimaryKey(id);
        if (i > 0) {
          return "redirect:selectAllUsers";
        }
        return "error";
    }

    /**
     *
     * @param response
     */
    @RequestMapping("/export")
    public void exportExcle(HttpServletResponse response) {
        ServletOutputStream out = null;
        UserController userController = new UserController();
        try {
            out = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            String fileName;
            fileName = new String(("Userinfo"+new SimpleDateFormat("yyyyMMdd").format(new Date())).getBytes(), "UTF-8");
            Sheet sheetone = new Sheet(1,0,User.class);
            sheetone.setSheetName("第一个sheet");
            Sheet sheettwo = new Sheet(2,3,User.class);
            sheettwo.setSheetName("第二个sheet");
            Sheet sheetthree= new Sheet(3,1,User.class);
            sheetthree.setSheetName("第三个sheet");
            //List<User> list = userService.selectAll();
            List<User> list = userController.getData();
            List<User> listone = new ArrayList<User>();
            List<User> listtwo = new ArrayList<User>();
            List<User> listthree = new ArrayList<User>();
            for (int i = 0; i< list.size(); i++) {
                if(i<50000) {
                    listone.add(list.get(i));
                }else if(i>=50000 && i<=100000) {
                    listtwo.add(list.get(i));
                }else if(i>=100000) {
                    listthree.add(list.get(i));
                }
            }
            writer.write(listone, sheetone);
            writer.write(listtwo, sheettwo);
            writer.write(listthree, sheetthree);
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");
            writer.finish();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
               if(null != out){
                   out.close();
               }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public List<User> getData(){
        List<User> list = new ArrayList<User>();
        for (int i = 1; i <= 1000000; i++) {
            User info = new User();
            info.setId(parseLong(i+""));
            info.setUsername("zhangsan");
            info.setPassword("gsq");
            info.setHeadPic("为什么么有");
            list.add(info);
        }
        return list;
    }
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String imgPath = request.getSession().getServletContext().getRealPath("/static/upload-files");
        File imgDir = new File(imgPath);
        if (!imgDir.exists()) {
            imgDir.mkdirs();
        }
        String oldFileName = file.getOriginalFilename();
        InputStream inputStream = null;
        try {
            file.transferTo(new File(imgDir,oldFileName));
            inputStream =  new FileInputStream(new File(imgDir,oldFileName));
            ExcelReader reader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, new AnalysisEventListener() {
                @Override
                public void invoke(Object o, AnalysisContext analysisContext) {
                    System.out.println("当前sheet"+analysisContext.getCurrentSheet().getSheetNo()+ " 当前行：" + analysisContext.getCurrentRowNum()
                            + " data:" + o.toString());
                    String str = o.toString();
                    String nstr = str.substring(0,str.length()-1);
                    String [] arry = nstr.split(",");
                    User user = new User();
                    user.setUsername(arry[1]);
                    user.setPassword(arry[2]);
                    user.setHeadPic(arry[3]);
                    if(analysisContext.getCurrentRowNum()!=0){
                        userService.insert(user);
                    }
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext analysisContext) {

                }
            });
            reader.read();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return "redirect:/";
    }
}
