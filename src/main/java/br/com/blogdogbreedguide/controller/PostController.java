package br.com.blogdogbreedguide.controller;

import br.com.blogdogbreedguide.entity.Post;
import br.com.blogdogbreedguide.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostService service;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = service.findAllPostList();
        mv.addObject("posts", posts);
        return mv;
    }

    @RequestMapping(value="/posts", method= RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = service.findAllPostList();
        mv.addObject("posts", posts);
        return mv;
    }

    @RequestMapping(value="/posts/{id}", method=RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = service.findPostById(id);
        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping(value="/newpost", method=RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    @RequestMapping(value="/newpost", method=RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("message", "Check that the mandatory fields have been completed!");
            return "redirect:/newpost";
        }
        post.setDate(LocalDate.now());
        service.createNewPost(post);
        return "redirect:/posts";
    }
}
