import java.util.ArrayList;

public class EstudianteService {
    private ArrayList<Estudiante> estudiantes;

    public EstudianteService(){
        estudiantes = new ArrayList<Estudiante>();
    }

    public ArrayList<Estudiante> getEstudiantes(){
        return estudiantes;
    }

    public Estudiante getEstudiante(int id){
        if(id >= estudiantes.size() || id < 0){
            return null;
        }else{
            return estudiantes.get(id);
        }
    }

    public void AgregarEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
    }

}
