package fit.se.gk.frontend.model;

import fit.se.gk.backend.enums.Roles;
import fit.se.gk.backend.models.Candidate;
import fit.se.gk.backend.models.Experience;
import fit.se.gk.backend.services.CandidateService;
import fit.se.gk.backend.services.ExperienceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class CandidateModel {
    private CandidateService service;
    private ExperienceService experienceService;

    public CandidateModel() {
        service= new CandidateService();
        experienceService= new ExperienceService();
    }
    public void insert(Candidate candidate){
        service.createCan(candidate);
    }
    public void getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Candidate> l = service.getAll();
        req.setAttribute("canList",l);
        req.getRequestDispatcher("candidates.jsp").forward(req,resp);
    }

    public void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object id = req.getParameter("id");
        if(id!=null){
            Candidate c = service.findById(Long.parseLong(id.toString()));
            List<Experience> e = experienceService.findByCanId(Long.parseLong(id.toString()));
            req.setAttribute("candidate",c);
            req.setAttribute("listExpr",e);
            req.getRequestDispatcher("candidate_details.jsp").forward(req,resp);
        }
    }

    public void formRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("report1.jsp");
    }
    public void findByRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String select= req.getParameter("select");
        List<Candidate> l = service.findByRole(Roles.valueOf(select));
        req.setAttribute("canList",l);
        req.getRequestDispatcher("report1.jsp").forward(req,resp);
    }

    public void formEmail(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Candidate> l = service.findByEmail();
        req.setAttribute("canList",l);
        req.getRequestDispatcher("report2.jsp").forward(req,resp);
    }
}
