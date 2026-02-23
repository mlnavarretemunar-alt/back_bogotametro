package co.bogotametro.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import co.bogotametro.web.modeloDao.PasajeroDAO;
import co.bogotametro.web.modeloVo.PasajeroVO;

@WebServlet("/inicio")
public class InicioServlet extends HttpServlet {

    @Override
     // Mostrar la página de login
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    // Procesar el formulario
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //1. Recibir los datos de las vistas 

        String pas_tipo_documento= request.getParameter("textpas_tipo_documento");
        String pas_nro_documento= request.getParameter("textpas_nro_documento");
        String pas_contrasena_encriptada= request.getParameter("textpas_contrasena_encriptada");
        int decision= Integer.parseInt(request.getParameter("decision"));

        //2. ¿quién tiene los datos de forma segura?

        PasajeroVO pasVO = new PasajeroVO(String pas_nom_pasajero, String pas_contrasena_encriptada, String pas_telefono, String pas_correo, String pas_tipo_documento, String pas_nro_documento, int pas_id_pasajero, Date pas_fecha_registro, boolean pas_status_pasajero);

        //3. ¿quién hace las operaciones del sistema?

        PasajeroDAO pasDao= new PasajeroDAO(pasVO);

        //4. Administrar las operaciones del sistema

        switch (decision) {
            case 1 : //Agregar registro:
                if(pasDao.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "El pasajero se registró correctamente");
                }else{
                    request.setAttribute("mensajeError", "El pasajero no se registró correctamente");
                }
                request.getRequestDispatcher("registrarUsuario.jsp").forward(request, response);
                break;

            case 2 : //Actualizar registro:
                if(pasDao.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El pasajero se actualizó correctamente");
                }else{
                    request.setAttribute("mensajeError", "El pasajero no se actualizó correctamente");
                }
                request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);
                break;

            case 3 : //Eliminar registro:
                if(pasDao.eliminarRegistro()) {
                    request.setAttribute("mensajeExito", "El pasajero se eliminó correctamente");
                }else{
                    request.setAttribute("mensajeError", "El pasajero no se eliminó correctamente");
                }
                request.getRequestDispatcher("eliminarUsuario.jsp").forward(request, response);
                break;

            case 4 : //Consultar registro:
                PasajeroVO pasVOConsultado = pasDao.consultarRegistro();
                if(pasVOConsultado != null) {
                    request.setAttribute("pasVOConsultado", pasVOConsultado);
                    request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response);
                }else{
                    request.setAttribute("mensajeError", "El pasajero no se encontró correctamente");
                }
                request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response);
                break;
            
            case 5: //Iniciar sesión:
                if(pasDao.iniciarSesion(pas_tipo_documento, pas_nro_documento, pas_contrasena_encriptada)) {
                    request.getRequestDispatcher("menu.jsp").forward(request, response);
                }else{
                    request.setAttribute("mensajeError", "El pasajero y/o la contraseña son incorrectos");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;
        }
    }
}
