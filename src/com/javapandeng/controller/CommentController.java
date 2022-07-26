package com.javapandeng.controller;

import com.javapandeng.base.BaseController;
import com.javapandeng.po.Comment;
import com.javapandeng.service.CommentService;
import com.javapandeng.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 公告管理
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/exAdd")
    public String exAdd(Comment comment, HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        if(attribute==null){
            return "redirect:/login/toLogin";
        }
        Integer userId = Integer.valueOf(attribute.toString());
        comment.setAddTime(new Date());
        comment.setUserId(userId);
        commentService.insert(comment);
        return "redirect:/itemOrder/my.action";
    }
}
