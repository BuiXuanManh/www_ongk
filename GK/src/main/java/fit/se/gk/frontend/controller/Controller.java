package fit.se.gk.frontend.controller;

import fit.se.gk.backend.enums.Roles;
import fit.se.gk.backend.models.Candidate;
import fit.se.gk.backend.models.Experience;
import fit.se.gk.frontend.model.CandidateModel;
import fit.se.gk.frontend.model.ExperienceModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    private CandidateModel candidateModel= new CandidateModel();
    private ExperienceModel experienceModel= new ExperienceModel();
//    @Override
//    public void init() throws ServletException {
//        Candidate c1= new Candidate("035254523","mail@mail","khai li");
//        Candidate c2= new Candidate("465425154","mail@mail","huy li");
//        Candidate c3= new Candidate("35164355","mail@mail","hung li");
//        Experience e1= new Experience("workDescription1", Roles.ADMINSTRATION, LocalDate.of(2023,1,1),LocalDate.of(2023,11,21),"Company1",c1);
//        Experience e2= new Experience("workDescription2", Roles.MANAGER, LocalDate.of(2023,1,1),LocalDate.of(2023,11,21),"Company2",c1);
//        Experience e3= new Experience("workDescription3", Roles.STAFF, LocalDate.of(2023,1,1),LocalDate.of(2023,11,21),"Company3",c1);
//        Experience e4= new Experience("workDescription4", Roles.EXECUTIVE, LocalDate.of(2023,1,1),LocalDate.of(2023,11,21),"Company4",c2);
//        Experience e5= new Experience("workDescription5", Roles.MANAGER, LocalDate.of(2023,1,1),LocalDate.of(2023,11,21),"Company5",c2);
//        Experience e6= new Experience("workDescription6", Roles.STAFF, LocalDate.of(2023,1,1),LocalDate.of(2023,11,21),"Company6",c2);
//        Experience e7= new Experience("workDescription7", Roles.EXECUTIVE, LocalDate.of(2023,1,1),LocalDate.of(2023,11,21),"Company7",c3);
//        Experience e8= new Experience("workDescription8", Roles.ADMINSTRATION, LocalDate.of(2023,1,1),LocalDate.of(2023,11,21),"Company8",c3);
//        Experience e9= new Experience("workDescription9", Roles.ADMINSTRATION, LocalDate.of(2023,1,1),LocalDate.of(2023,11,21),"Company9",c3);
//        candidateModel.insert(c1);
//        candidateModel.insert(c2);
//        candidateModel.insert(c3);
//        experienceModel.insert(e1);
//        experienceModel.insert(e2);
//        experienceModel.insert(e3);
//        experienceModel.insert(e4);
//        experienceModel.insert(e5);
//        experienceModel.insert(e6);
//        experienceModel.insert(e7);
//        experienceModel.insert(e8);
//        experienceModel.insert(e9);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object action= req.getParameter("action");
        if(action!=null){
            if(action.equals("list")){
                candidateModel.getList(req,resp);
            }
            else if(action.equals("view")){
                candidateModel.view(req,resp);
            }
            else if(action.equals("findByRole")){
                candidateModel.formRole(req,resp);
            }
            else if(action.equals("findByEmail")){
                candidateModel.formEmail(req,resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object action= req.getParameter("action");
        if(action!=null){
            if(action.equals("role")){
                candidateModel.findByRole(req,resp);
            }
        }
    }
}
