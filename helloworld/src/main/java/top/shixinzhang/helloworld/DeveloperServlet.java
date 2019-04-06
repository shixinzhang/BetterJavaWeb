package top.shixinzhang.helloworld;

import top.shixinzhang.helloworld.db.dao.DeveloperDao;
import top.shixinzhang.helloworld.db.model.CommonModel;
import top.shixinzhang.helloworld.db.model.DeveloperModel;
import top.shixinzhang.helloworld.util.ConstantUtil;
import top.shixinzhang.helloworld.util.GsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by zhangshixin on 19/4/6.
 */
@WebServlet(name = "DeveloperServlet",
        urlPatterns = {ConstantUtil.ALL_DEVELOPERS_URL, ConstantUtil.ADD_DEVELOPER_URL,
                ConstantUtil.DELETE_DEVELOPER_URL, ConstantUtil.UPDATE_DEVELOPER_URL,
                ConstantUtil.QUERY_DEVELOPER_URL})
public class DeveloperServlet extends HttpServlet {

    DeveloperDao developerDao = new DeveloperDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("url:" + request.getRequestURL());
        System.out.println("param id:" + request.getParameter("id"));
        System.out.println("param name:" + request.getParameter("name"));

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/json;charset=UTF-8");

//        PrintWriter writer = response.getWriter();
//        writer.println("<h2>Hello Servlet</h2>");

        handleRequestByUrl(request, response);

    }

    private void handleRequestByUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {

        final String uri = request.getRequestURI();
        final String url = request.getRequestURL().toString();

        System.out.println(uri + "\n" + url);

        switch (uri) {
            case ConstantUtil.ALL_DEVELOPERS_URL:
                getAllDevelopers(request, response);
                break;
            case ConstantUtil.QUERY_DEVELOPER_URL:
                getDeveloperInfoById(request, response);
                break;
            case ConstantUtil.ADD_DEVELOPER_URL:
                addDeveloper(request, response);
                break;
            case ConstantUtil.UPDATE_DEVELOPER_URL:
                updateDeveloper(request, response);
                break;
            case ConstantUtil.DELETE_DEVELOPER_URL:
                deleteDeveloper(request, response);
                break;
        }
    }

    private void deleteDeveloper(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");

        CommonModel commonModel = new CommonModel();
        if (developerDao.deleteDeveloper(id)) {

            commonModel.setSuccess();
            commonModel.setData("删除成功");
        } else {
            commonModel.setFail();
        }
        printResponse(response, commonModel);
    }

    private void updateDeveloper(HttpServletRequest request, HttpServletResponse response) {

    }

    private void addDeveloper(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String avatar = request.getParameter("avatar");
        String site = request.getParameter("site");

        DeveloperModel developerModel = new DeveloperModel();
        developerModel.setName(name);
        developerModel.setAvatar(avatar);
        developerModel.setSite(site);

        CommonModel commonModel = new CommonModel();
        if (developerDao.addDeveloper(developerModel)) {
            commonModel.setSuccess();
            commonModel.setData(developerModel);
        } else {
            commonModel.setFail();
        }
        printResponse(response, commonModel);
    }

    private void getDeveloperInfoById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        DeveloperModel developerModel = developerDao.getDeveloper(id);
        CommonModel commonModel = new CommonModel();
        if (developerModel == null) {
            commonModel.setFail();
        } else {
            commonModel.setSuccess();
            commonModel.setData(developerModel);
        }
        printResponse(response, commonModel);
    }

    private void getAllDevelopers(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<DeveloperModel> developerList = developerDao.getAllDevelopers();
        CommonModel commonModel = new CommonModel();
        if (developerList.size() > 0) {
            commonModel.setSuccess();
            commonModel.setData(developerList);
        } else {
            commonModel.setFail();
        }
        printResponse(response, commonModel);
    }

    private void printResponse(HttpServletResponse response, CommonModel commonModel) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println(GsonUtil.bean2Json(commonModel));
        printWriter.flush();
        printWriter.close();
    }
}
