package com.egg.biblioteca.controladores;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class ErroresControlador implements ErrorController {
    
    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        
        String errorMsg = "";
        int httpErrorCode = (int) request.getAttribute("jakarta.servlet.error.status_code");

        switch (httpErrorCode) {
            case 400:
                errorMsg = "El recurso solicitado no existe.";
                break;
            case 401:
                errorMsg = "No se encuentra autorizado.";
                break;
            case 403:
                errorMsg = "No tiene permisos para acceder al recurso.";
                break;
            case 404:
                errorMsg = "El recurso solicitado no fue encontrado.";
                break;
            case 500:
                errorMsg = "Ocurrió un error interno en el servidor.";
                break;
            default:
                errorMsg = "Error inesperado.";
        }

        modelAndView.addObject("codigo", httpErrorCode);
        modelAndView.addObject("mensaje", errorMsg);
        return modelAndView;
    }
}
