package org.erp.school.views.about;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.erp.school.views.main.MainView;

@Route(value = "about", layout = MainView.class)
@PageTitle("About")
@JsModule("./src/views/about/about-view.ts")
@CssImport("./styles/views/about/about-view.css")
@Tag("about-view")
public class AboutView extends LitTemplate {

    // This is the Java companion file of a design
    // You can find the design file in
    // /frontend/src/views/src/views/about/about-view.ts

    public AboutView() {
    }
}
