package com.jetbrains;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
          HorizontalLayout layout1=new HorizontalLayout( );
        
        final TextField cantidadV = new TextField();
        cantidadV.setCaption("Ingrese cantidad de vehiculos del propietario");

        final TextField codigoP = new TextField();
        codigoP.setCaption("Ingrese codigo del propietario");

        final TextField nombreP = new TextField();
        nombreP.setCaption("Ingrese nombre del propietario");

        final TextField edadP = new TextField();
        edadP.setCaption("Ingrese edad del propietario");

        final TextField sexoP = new TextField();
        sexoP.setCaption("Ingrese sexo del propietario");

        Button button = new Button("Guardar");
        button.addClickListener( e -> {
            layout.addComponent(new Label("Cantidad: " + cantidadV.getValue() ));
            layout.addComponent(new Label("Codigo: " + codigoP.getValue() ));
            layout.addComponent(new Label("Nombre: " + nombreP.getValue() ));
            layout.addComponent(new Label("Edad: " + edadP.getValue() ));
            layout.addComponent(new Label("Sexo: " + sexoP.getValue() ));


        });

        layout.addComponents(cantidadV,codigoP,nombreP,edadP,sexoP, button);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
