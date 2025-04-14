package org.dasher.speed.dashboard.ui.views;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.dasher.speed.base.ui.view.MainLayout;
import org.dasher.speed.project.service.ProjectService;
import org.dasher.speed.taskmanagement.service.TaskService;

@PageTitle("Dashboard | PM Dashboard")
@Route (value = "dashboard", layout = MainLayout.class)
public class DashboardView extends VerticalLayout {

    public DashboardView (ProjectService projectService, TaskService taskService) {
        addClassName("dashboard-view");
        setSizeFull();
        setPadding(true);
        setSpacing(true);

        add(
                new H2("Dashboard"),
                createProjectsChart(projectService),
                new H2("Task Status"),
                createTasksChart(taskService)
        );
    }

    private Chart createProjectsChart(ProjectService projectService) {
        Chart chart = new Chart(ChartType.PIE);

        Configuration conf = chart.getConfiguration();
        conf.setTitle("Projects by Phase");

        DataSeries series = new DataSeries();
        projectService.countProjectsByPhase().forEach((phase,count) ->
                series.add(new DataSeriesItem(phase.name(),count)));

            conf.addSeries(series);
            return chart;
    }

    private Chart createTasksChart (TaskService taskService) {
        Chart chart = new Chart(ChartType.COLUMN);

        Configuration conf = chart.getConfiguration();
        conf.setTitle("Tasks by Status ");

        XAxis xAxis = new XAxis();
        xAxis.setCategories("Backlog", "In Progress", "In Review", "Completed", "Blocked");
        conf.addxAxis(xAxis);

        YAxis yAxis = new YAxis();
        yAxis.setTitle("Number of Tasks");
        conf.addyAxis(yAxis);

        DataSeries series = new DataSeries();
        taskService.countTasksByStatus().forEach ((status,count) ->
                series.add(new DataSeriesItem(status.name(), count)));

        conf.addSeries(series);
        return chart;
    }



}
