package org.erp.school.views.helloworld;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.erp.school.views.main.MainView;

/**
 * A Designer generated component for the hello-world-view template.
 * <p>
 * Designer will add and remove fields with @Id mappings but does not overwrite
 * or otherwise change this file.
 */
@Route(value = "hello", layout = MainView.class)
@PageTitle("Hello World")
@JsModule("./src/views/helloworld/hello-world-view.ts")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@Tag("hello-world-view")
@RouteAlias(value = "", layout = MainView.class)
public class HelloWorldView extends LitTemplate {

    @Id
    private TextField name;

    @Id
    private Button sayHello;

    public HelloWorldView() {
        sayHello.addClickListener(e -> Notification.show("Hello " + name.getValue()));
    }
}
