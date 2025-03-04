package springboot;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.dao.ISimpleBbsDao;

@Controller
public class MyController {

    @Autowired
    private ISimpleBbsDao dao;

    @RequestMapping("/")
    public String root() throws Exception {
        // MyBatis : SimpleBBS
        return "redirect:list";
    } // f end

    @RequestMapping("/list")
    public String userlistPage(Model model) {
        model.addAttribute("list", dao.listDao());
        return "list";
    } // f end

    @RequestMapping("view")
    public String view(HttpServletRequest req, Model model) {
        String sId = req.getParameter("id");
        model.addAttribute("dto", dao.viewDao(sId));
        return "view";
    } // f end

    @RequestMapping("/writeForm")
    public String writeForm() {

        return "writeForm";
    } // f end

    @RequestMapping("/write")
    public String write(HttpServletRequest req, Model model) {
        dao.writeDao( req.getParameter("writer"),
                    req.getParameter("title"),
                    req.getParameter("content") );
        return "redirect:list";
    } // f end

    @RequestMapping("/delete")
    public String delete(HttpServletRequest req, Model model) {
        dao.deleteDao(req.getParameter("id"));
        return "redirect:list";
    } // f end

}
