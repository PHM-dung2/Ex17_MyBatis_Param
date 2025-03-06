package springboot;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.dao.ISimpleBbsDao;
import springboot.service.ISimpleService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {

//    @Autowired
//    private ISimpleBbsDao dao;

    @Autowired
    ISimpleService bbs;

    @RequestMapping("/")
    public String root() throws Exception {
        // Service vs DAO
        return "redirect:list";
    } // f end

    @RequestMapping("/list")
    public String userlistPage(Model model) {
//        model.addAttribute("list", dao.listDao());
        model.addAttribute("list", bbs.list());

        int nTotalCount = bbs.count();
        System.out.println("Count : " + nTotalCount);

        return "/list";
    } // f end

    @RequestMapping("view")
    public String view(HttpServletRequest req, Model model) {
        String sId = req.getParameter("id");
        model.addAttribute("dto", bbs.view(sId));
        return "/view";
    } // f end

    @RequestMapping("/writeForm")
    public String writeForm() {

        return "/writeForm";
    } // f end

    @RequestMapping("/write")
    public String write(HttpServletRequest req, Model model) {

        String sName = req.getParameter("writer");
        String sTitle = req.getParameter("title");
        String sContent = req.getParameter("content");

        Map<String, String> map = new HashMap<String, String>();
        map.put("item1", sName);
        map.put("item2", sTitle);
        map.put("item3", sContent);

        int nResult = bbs.write(map);
        System.out.println("Write : " + nResult);

        return "redirect:list";
    } // f end

    @RequestMapping("/delete")
    public String delete(HttpServletRequest req, Model model) {
        String sId = req.getParameter("id");
        int nResult = bbs.delete(sId);
        System.out.println("Delete : " + nResult);

        return "redirect:list";
    } // f end

}
