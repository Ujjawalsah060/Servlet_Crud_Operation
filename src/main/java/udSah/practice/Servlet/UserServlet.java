package udSah.practice.Servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import udSah.practice.Model.User;
import udSah.practice.Services.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();


    // =========================
    // CREATE USER
    // POST /users
    // =========================
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException {

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if (idParam == null ||
                name == null ||
                email == null ||
                mobile == null) {

            response.setStatus(400);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"Some fields are missing\"\n" +
                            "}"
            );

            return;
        }

        Long id = Long.parseLong(idParam);

        User user = new User(
                id,
                name,
                email,
                mobile
        );

        userService.createUser(user);

        response.setStatus(201);
        response.setContentType("application/json");

        response.getWriter().write(
                "{\n" +
                        "    \"message\" : \"User Added successfully\"\n" +
                        "}"
        );
    }


    // =========================
    // GET USERS
    // GET /users
    // GET /users?id=1
    // =========================
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException {

        String idParam = request.getParameter("id");

        response.setContentType("application/json");

        // Get all users
        if (idParam == null) {

            List<User> users =
                    userService.getAllUsers();

            response.setStatus(200);

            response.getWriter().write(
                    usersToJson(users)
            );

        }

        // Get user by ID
        else {

            Long id = Long.parseLong(idParam);

            User userResp =
                    userService.getUserById(id);

            if (userResp == null) {

                response.setStatus(404);

                response.getWriter().write(
                        "{\n" +
                                "    \"message\" : \"User not found\"\n" +
                                "}"
                );

                return;
            }

            response.setStatus(200);

            response.getWriter().write(
                    userToJson(userResp)
            );
        }
    }


    // =========================
    // UPDATE USER
    // PUT /users?id=1
    // =========================
    @Override
    public void doPut(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException {

        String idParam = request.getParameter("id");

        if (idParam == null) {

            response.setStatus(400);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"User ID is required\"\n" +
                            "}"
            );

            return;
        }

        Long id = Long.parseLong(idParam);

        User user = userService.getUserById(id);

        if (user == null) {

            response.setStatus(404);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"User not found\"\n" +
                            "}"
            );

            return;
        }

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if (name == null ||
                email == null ||
                mobile == null) {

            response.setStatus(400);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"Some fields are missing\"\n" +
                            "}"
            );

            return;
        }

        user.setName(name);
        user.setEmail(email);
        user.setMobile(mobile);

        response.setStatus(200);
        response.setContentType("application/json");

        response.getWriter().write(
                "{\n" +
                        "    \"message\" : \"User updated successfully\"\n" +
                        "}"
        );
    }


    // =========================
    // DELETE USER
    // DELETE /users?id=1
    // =========================
    @Override
    public void doDelete(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        String idParam = request.getParameter("id");

        if (idParam == null) {

            response.setStatus(400);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"User ID is required\"\n" +
                            "}"
            );

            return;
        }

        Long id = Long.parseLong(idParam);

        User user = userService.getUserById(id);

        if (user == null) {

            response.setStatus(404);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"User not found\"\n" +
                            "}"
            );

            return;
        }

        userService.deleteUser(id);

        response.setStatus(200);
        response.setContentType("application/json");

        response.getWriter().write(
                "{\n" +
                        "    \"message\" : \"User deleted successfully\"\n" +
                        "}"
        );
    }


    // =========================
    // USER TO JSON
    // =========================
    private String userToJson(User user) {

        return "{\n" +
                "    \"id\" : " + user.getId() + ",\n" +
                "    \"name\" : \"" + user.getName() + "\",\n" +
                "    \"email\" : \"" + user.getEmail() + "\",\n" +
                "    \"mobile\" : \"" + user.getMobile() + "\"\n" +
                "}";
    }


    // =========================
    // USERS TO JSON
    // =========================
    private String usersToJson(List<User> users) {

        StringBuilder stringBuilder =
                new StringBuilder();

        stringBuilder.append("[");

        for (int i = 0; i < users.size(); i++) {

            stringBuilder.append(
                    userToJson(users.get(i))
            );

            if (i < users.size() - 1) {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}