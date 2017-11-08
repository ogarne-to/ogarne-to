package to.ogarne.ogarneblog.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import to.ogarne.ogarneblog.mockdata.DatabaseLoader;

@Profile("dev")
@Controller
public class MockDataController {


    @Autowired
    DatabaseLoader databaseLoader;


    @RequestMapping("/mockdata")
    public String getIndex(Model model) {
        databaseLoader.run();

        return "redirect:/";
    }
}
