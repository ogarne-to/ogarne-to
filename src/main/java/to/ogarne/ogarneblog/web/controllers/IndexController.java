package to.ogarne.ogarneblog.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import to.ogarne.ogarneblog.model.Page;
import to.ogarne.ogarneblog.service.PageService;
import to.ogarne.ogarneblog.service.PostService;
import to.ogarne.ogarneblog.web.MarkdownParser;

import java.util.List;

@Controller
public class IndexController extends  RootController{

    @Autowired
    PostService postService;

    @Autowired
    PageService pageService;


    @Autowired
    MarkdownParser markdownParser;

    @RequestMapping("/")
    public String getIndex(Model model) {
        Page homePage = pageService.findBySlug("home");
        markdownParser.parse(homePage);
        model.addAttribute("homePage", homePage);
        List<Page> menuItems = getMenu();
        menuItems.get(0).setActive(true);
        model.addAttribute("menuItems", menuItems);

        return "index";
    }


}
