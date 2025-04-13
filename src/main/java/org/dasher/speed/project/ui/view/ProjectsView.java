package org.dasher.speed.project.ui.view;

import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route("projects")
@PageTitle("projects")
@Menu(order = 1, icon = "vaadin:briefcase", title = "Projects")
public class ProjectsView extends Main {
    public ProjectsView () {
        setText("Projects View");
    }
}
