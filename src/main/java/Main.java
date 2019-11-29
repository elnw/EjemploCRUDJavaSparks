import static spark.Spark.*;
public class Main {
    public static void main(String[] args) {
        EstudianteService estudianteService = new EstudianteService();
        estudianteService.AgregarEstudiante(new Estudiante("katherin", "chuco","tendencias"));
        estudianteService.AgregarEstudiante(new Estudiante("Ana Paula", "Santillan","tendencias"));

        get("/estudiantes", (req, res) -> estudianteService.getEstudiantes(), JsonUtil.json());
        get("/estudiantes/:id", (req, res) -> {
            String id = req.params(":id");
            Estudiante user = estudianteService.getEstudiante(Integer.parseInt(id) - 1);
            if (user != null) {
                return user;
            }
            res.status(400);
            return new ResponseError("No se encontró usuario con este id: '%s' ", id);
        }, JsonUtil.json());
        post("/estudiantes", (req, res) -> {
            String nombre = req.queryParams("nombre");
            String apellido = req.queryParams("apellido");
            String curso = req.queryParams("curso");
            Estudiante estudiante = new Estudiante(nombre,apellido,curso);
            estudianteService.AgregarEstudiante(estudiante);
            res.status(200);
            return estudiante;
        }, JsonUtil.json());

        after((req, res) -> {
            res.type("application/json");
        });
    }
}
