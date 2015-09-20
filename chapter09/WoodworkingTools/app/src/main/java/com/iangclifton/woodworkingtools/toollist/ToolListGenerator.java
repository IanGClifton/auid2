package com.iangclifton.woodworkingtools.toollist;

import android.support.annotation.DrawableRes;

import com.iangclifton.woodworkingtools.R;
import com.iangclifton.woodworkingtools.Tool;

import java.util.ArrayList;
import java.util.List;

/**
 * Crude class that returns example lists of tools.
 *
 * @author Ian G. Clifton
 */
public class ToolListGenerator {

    public static List<Tool> getTools(ToolTab toolTab) {
        switch (toolTab.getToolType()) {

            case CLAMPS:
                return getClamps(toolTab);
            case SAWS:
                return getSaws(toolTab);
            case DRILLS:
                return getDrills(toolTab);
            case SANDERS:
                return getSanders(toolTab);
            case ROUTERS:
                return getRouters(toolTab);
            case LATHES:
                return getLathes(toolTab);
            case MORE:
            default:
                return getGenericToolList(R.drawable.hero_image_more);
        }
    }

    private static List<Tool> getClamps(ToolTab toolTab) {
        final List<Tool> tools = new ArrayList<>();
        final String description = "This clamp has the power to hold together the toughest of glue jobs while the non-marring surface ensures it leaves no marks. It is easy to use, light, and strong, so you will be able to use it for a wide variety of projects. Non-slip pads keep precise alignment and a replaceable for years down the road when they're worn from the harsh treatment you can give them.";
        switch (toolTab.getStringResourceId()) {
            case R.string.parallel_clamps:
                tools.add(new Tool("Acme Parallel Clamp", "$5", new String[] {"6\" Capacity"}, description, R.drawable.clamp_other_01, R.drawable.thumbnail_clamp_other_01));
                tools.add(new Tool("Couch Parallel Clamp", "$12", new String[] {"6\" Capacity"}, description, R.drawable.clamp_other_02, R.drawable.thumbnail_clamp_other_02));
                tools.add(new Tool("Devil Parallel Clamp", "$15", new String[] {"12\" Capacity"}, description, R.drawable.clamp_other_03, R.drawable.thumbnail_clamp_other_03));
                tools.add(new Tool("Devil Parallel Clamp", "$15", new String[] {"12\" Capacity"}, description, R.drawable.clamp_other_01, R.drawable.thumbnail_clamp_other_01));
                tools.add(new Tool("Acme Parallel Clamp", "$19", new String[] {"18\" Capacity"}, description, R.drawable.clamp_other_03, R.drawable.thumbnail_clamp_other_03));
                tools.add(new Tool("Bullet Parallel Clamp", "$25", new String[] {"24\" Capacity"}, description, R.drawable.clamp_other_02, R.drawable.thumbnail_clamp_other_02));
                tools.add(new Tool("Couch Parallel Clamp", "$30", new String[] {"36\" Capacity"}, description, R.drawable.clamp_other_01, R.drawable.thumbnail_clamp_other_01));
                tools.add(new Tool("Devil Parallel Clamp", "$50", new String[] {"48\" Capacity"}, description, R.drawable.clamp_other_02, R.drawable.thumbnail_clamp_other_02));
                tools.add(new Tool("Acme Parallel Clamp Assortment", "$50", new String[] {"5 Clamps"}, description, R.drawable.clamp_other_03, R.drawable.thumbnail_clamp_other_03));
                tools.add(new Tool("Bullet Parallel Clamp Pack", "$55", new String[] {"8 Clamps"}, description, R.drawable.clamp_other_01, R.drawable.thumbnail_clamp_other_01));
                return tools;
            case R.string.spring_clamps:
                tools.add(new Tool("Acme Spring Clamp", "$5", new String[] {"1\" Capacity"}, description, R.drawable.clamp_spring_01, R.drawable.thumbnail_clamp_spring_01));
                tools.add(new Tool("Couch Spring Clamp", "$12", new String[] {"1\" Capacity"}, description, R.drawable.clamp_spring_02, R.drawable.thumbnail_clamp_spring_02));
                tools.add(new Tool("Devil Spring Clamp", "$15", new String[] {"2\" Capacity"}, description, R.drawable.clamp_spring_01, R.drawable.thumbnail_clamp_spring_01));
                tools.add(new Tool("Devil Spring Clamp", "$15", new String[] {"2\" Capacity"}, description, R.drawable.clamp_spring_02, R.drawable.thumbnail_clamp_spring_02));
                tools.add(new Tool("Acme Spring Clamp", "$19", new String[] {"3\" Capacity"}, description, R.drawable.clamp_spring_03, R.drawable.thumbnail_clamp_spring_03));
                tools.add(new Tool("Bullet Spring Clamp", "$25", new String[] {"3\" Capacity"}, description, R.drawable.clamp_spring_02, R.drawable.thumbnail_clamp_spring_02));
                tools.add(new Tool("Couch Spring Clamp", "$30", new String[] {"5\" Capacity"}, description, R.drawable.clamp_spring_03, R.drawable.thumbnail_clamp_spring_03));
                tools.add(new Tool("Devil Spring Clamp", "$50", new String[] {"5\" Capacity"}, description, R.drawable.clamp_spring_02, R.drawable.thumbnail_clamp_spring_02));
                tools.add(new Tool("Acme Spring Clamp Assortment", "$50", new String[] {"5 Clamps"}, description, R.drawable.clamp_spring_03, R.drawable.thumbnail_clamp_spring_03));
                tools.add(new Tool("Bullet Spring Clamp Pack", "$55", new String[] {"8 Clamps"}, description, R.drawable.clamp_spring_04, R.drawable.thumbnail_clamp_spring_04));
                return tools;
            case R.string.pipe_clamps:
                tools.add(new Tool("Acme Pipe Clamp", "$5", new String[] {"6\" Capacity"}, description, R.drawable.clamp_other_01, R.drawable.thumbnail_clamp_other_01));
                tools.add(new Tool("Couch Pipe Clamp", "$12", new String[] {"6\" Capacity"}, description, R.drawable.clamp_other_02, R.drawable.thumbnail_clamp_other_02));
                tools.add(new Tool("Devil Pipe Clamp", "$15", new String[] {"12\" Capacity"}, description, R.drawable.clamp_other_03, R.drawable.thumbnail_clamp_other_03));
                tools.add(new Tool("Devil Pipe Clamp", "$15", new String[] {"12\" Capacity"}, description, R.drawable.clamp_other_02, R.drawable.thumbnail_clamp_other_02));
                tools.add(new Tool("Acme Pipe Clamp", "$19", new String[] {"18\" Capacity"}, description, R.drawable.clamp_other_01, R.drawable.thumbnail_clamp_other_01));
                tools.add(new Tool("Bullet Pipe Clamp", "$25", new String[] {"24\" Capacity"}, description, R.drawable.clamp_other_01, R.drawable.thumbnail_clamp_other_01));
                tools.add(new Tool("Couch Pipe Clamp", "$30", new String[] {"36\" Capacity"}, description, R.drawable.clamp_other_02, R.drawable.thumbnail_clamp_other_02));
                tools.add(new Tool("Devil Pipe Clamp", "$50", new String[] {"48\" Capacity"}, description, R.drawable.clamp_other_03, R.drawable.thumbnail_clamp_other_03));
                tools.add(new Tool("Acme Pipe Clamp Assortment", "$50", new String[] {"5 Clamps"}, description, R.drawable.clamp_other_03, R.drawable.thumbnail_clamp_other_03));
                tools.add(new Tool("Bullet Pipe Clamp Pack", "$55", new String[] {"8 Clamps"}, description, R.drawable.clamp_other_01, R.drawable.thumbnail_clamp_other_01));
                return tools;
            case R.string.bar_clamps:
                tools.add(new Tool("Acme Bar Clamp", "$5", new String[] {"6\" Capacity"}, description, R.drawable.clamp_other_01, R.drawable.thumbnail_clamp_other_01));
                tools.add(new Tool("Couch Bar Clamp", "$12", new String[] {"6\" Capacity"}, description, R.drawable.clamp_other_02, R.drawable.thumbnail_clamp_other_02));
                tools.add(new Tool("Devil Bar Clamp", "$15", new String[] {"12\" Capacity"}, description, R.drawable.clamp_other_01, R.drawable.thumbnail_clamp_other_01));
                tools.add(new Tool("Devil Bar Clamp", "$15", new String[] {"12\" Capacity"}, description, R.drawable.clamp_other_03, R.drawable.thumbnail_clamp_other_03));
                tools.add(new Tool("Acme Bar Clamp", "$19", new String[] {"18\" Capacity"}, description, R.drawable.clamp_other_02, R.drawable.thumbnail_clamp_other_02));
                tools.add(new Tool("Bullet Bar Clamp", "$25", new String[] {"24\" Capacity"}, description, R.drawable.clamp_other_01, R.drawable.thumbnail_clamp_other_01));
                tools.add(new Tool("Couch Bar Clamp", "$30", new String[] {"36\" Capacity"}, description, R.drawable.clamp_other_03, R.drawable.thumbnail_clamp_other_03));
                tools.add(new Tool("Devil Bar Clamp", "$50", new String[] {"48\" Capacity"}, description, R.drawable.clamp_other_02, R.drawable.thumbnail_clamp_other_02));
                tools.add(new Tool("Acme Bar Clamp Assortment", "$50", new String[] {"5 Clamps"}, description, R.drawable.clamp_other_03, R.drawable.thumbnail_clamp_other_03));
                tools.add(new Tool("Bullet Bar Clamp Pack", "$55", new String[] {"8 Clamps"}, description, R.drawable.clamp_other_03, R.drawable.thumbnail_clamp_other_03));
                return tools;
            case R.string.toggle_clamps:
                tools.add(new Tool("Acme Toggle Clamp", "$5", new String[] {"1\" Capacity"}, description, R.drawable.clamp_other_01, R.drawable.thumbnail_clamp_other_01));
                tools.add(new Tool("Couch Toggle Clamp", "$12", new String[] {"1\" Capacity"}, description, R.drawable.clamp_other_02, R.drawable.thumbnail_clamp_other_02));
                tools.add(new Tool("Devil Toggle Clamp", "$15", new String[] {"2\" Capacity"}, description, R.drawable.clamp_other_01, R.drawable.thumbnail_clamp_other_01));
                tools.add(new Tool("Devil Toggle Clamp", "$15", new String[] {"2\" Capacity"}, description, R.drawable.clamp_other_03, R.drawable.thumbnail_clamp_other_03));
                tools.add(new Tool("Acme Toggle Clamp", "$19", new String[] {"3\" Capacity"}, description, R.drawable.clamp_other_03, R.drawable.thumbnail_clamp_other_03));
                tools.add(new Tool("Bullet Toggle Clamp", "$25", new String[] {"5\" Capacity"}, description, R.drawable.clamp_other_01, R.drawable.thumbnail_clamp_other_01));
                tools.add(new Tool("Couch Toggle Clamp", "$30", new String[] {"5\" Capacity"}, description, R.drawable.clamp_other_03, R.drawable.thumbnail_clamp_other_03));
                tools.add(new Tool("Devil Toggle Clamp", "$50", new String[] {"6\" Capacity"}, description, R.drawable.clamp_other_02, R.drawable.thumbnail_clamp_other_02));
                tools.add(new Tool("Acme Toggle Clamp Assortment", "$50", new String[] {"5 Clamps"}, description, R.drawable.clamp_other_03, R.drawable.thumbnail_clamp_other_03));
                tools.add(new Tool("Bullet Toggle Clamp Pack", "$55", new String[] {"8 Clamps"}, description, R.drawable.clamp_other_02, R.drawable.thumbnail_clamp_other_02));
                return tools;
        }
        return getGenericToolList(R.drawable.hero_image_clamps);
    }

    private static List<Tool> getSaws(ToolTab toolTab) {
        final List<Tool> tools = new ArrayList<>();
        final String description = "";
        switch (toolTab.getStringResourceId()) {
            case R.string.table_saws:
            case R.string.band_saws:
            case R.string.jig_saws:
            case R.string.circular_saws:
        }
        return getGenericToolList(R.drawable.hero_image_saw);
    }

    private static List<Tool> getDrills(ToolTab toolTab) {
        final List<Tool> tools = new ArrayList<>();
        final String description = "";
        switch (toolTab.getStringResourceId()) {
            case R.string.handheld:
                tools.add(new Tool("Acme Drill", "$45", new String[] {"12V"}, description, R.drawable.drill_handheld_03, R.drawable.thumbnail_drill_handheld_03));
                tools.add(new Tool("Couch Drill", "$55", new String[] {"12V"}, description, R.drawable.drill_handheld_02, R.drawable.thumbnail_drill_handheld_02));
                tools.add(new Tool("Devil Drill", "$75", new String[] {"Corded"}, description, R.drawable.drill_handheld_01, R.drawable.thumbnail_drill_handheld_01));
                tools.add(new Tool("Devil Drill", "$105", new String[] {"24V"}, description, R.drawable.drill_handheld_03, R.drawable.thumbnail_drill_handheld_03));
                tools.add(new Tool("Acme Drill", "$115", new String[] {"Corded"}, description, R.drawable.drill_handheld_01, R.drawable.thumbnail_drill_handheld_01));
                tools.add(new Tool("Bullet Drill", "$120", new String[] {"18V"}, description, R.drawable.drill_handheld_03, R.drawable.thumbnail_drill_handheld_03));
                tools.add(new Tool("Couch Drill", "$150", new String[] {"24V"}, description, R.drawable.drill_handheld_02, R.drawable.thumbnail_drill_handheld_02));
                tools.add(new Tool("Devil Drill", "$190", new String[] {"Corded"}, description, R.drawable.drill_handheld_01, R.drawable.thumbnail_drill_handheld_01));
                tools.add(new Tool("Acme Drill", "$240", new String[] {"18V"}, description, R.drawable.drill_handheld_02, R.drawable.thumbnail_drill_handheld_02));
                tools.add(new Tool("Bullet Drill", "$295", new String[] {"24V"}, description, R.drawable.drill_handheld_03, R.drawable.thumbnail_drill_handheld_03));
                return tools;
            case R.string.stationary:
        }
        return getGenericToolList(R.drawable.hero_image_drill);
    }

    private static List<Tool> getRouters(ToolTab toolTab) {
        final List<Tool> tools = new ArrayList<>();
        final String description = "";
        return getGenericToolList(R.drawable.hero_image_router);
    }

    private static List<Tool> getSanders(ToolTab toolTab) {
        final List<Tool> tools = new ArrayList<>();
        final String description = "This sander has enough power to easily shape tough pieces of wood and enough finesse to ensure the smoothest of finishes. The standard sized ports allow you to hook up a shop vacuum or air filtration system to ensure the majority of dust never settles in your shop.";
        switch (toolTab.getStringResourceId()) {
            case R.string.stationary:
                tools.add(new Tool("Acme Spindle Sander", "$325", new String[] {"Spindle", "1/2 HP"}, description, R.drawable.hero_image_sander, R.drawable.thumbnail_sander_01));
                tools.add(new Tool("Couch Belt and Disc Sander", "$375", new String[] {"Belt/Disc", "3/4 HP"}, description, R.drawable.hero_image_sander, R.drawable.thumbnail_sander_01));
                tools.add(new Tool("Devil Spindle Sander", "$455", new String[] {"Spindle", "3/4 HP"}, description, R.drawable.hero_image_sander, R.drawable.thumbnail_sander_01));
                tools.add(new Tool("Devil Belt and Disc Sander", "$525", new String[] {"Belt/Disc", "1 HP"}, description, R.drawable.hero_image_sander, R.drawable.thumbnail_sander_01));
                tools.add(new Tool("Acme Disc Sander", "$555", new String[] {"Disc", "1 HP"}, description, R.drawable.hero_image_sander, R.drawable.thumbnail_sander_01));
                tools.add(new Tool("Bullet Spindle Sander", "$600", new String[] {"Spindle", "1 HP"}, description, R.drawable.hero_image_sander, R.drawable.thumbnail_sander_01));
                tools.add(new Tool("Couch Disc Sander", "$640", new String[] {"Disc", "1 HP"}, description, R.drawable.hero_image_sander, R.drawable.thumbnail_sander_01));
                tools.add(new Tool("Devil Drum Sander", "$700", new String[] {"Drum", "1.5 HP"}, description, R.drawable.hero_image_sander, R.drawable.thumbnail_sander_01));
                tools.add(new Tool("Acme Drum Sander", "$780", new String[] {"Drum", "2 HP"}, description, R.drawable.hero_image_sander, R.drawable.thumbnail_sander_01));
                tools.add(new Tool("Bullet Drum Sander", "$914", new String[] {"Drum", "2 HP"}, description, R.drawable.hero_image_sander, R.drawable.thumbnail_sander_01));
                return tools;

            case R.string.handheld:
                tools.add(new Tool("Acme Random Orbital Sander", "$45", new String[] {"Random Orbital", "5\""}, description, R.drawable.sander_handheld_01, R.drawable.thumbnail_sander_handheld_01));
                tools.add(new Tool("Couch Belt Sander", "$55", new String[] {"Belt", "2.5\""}, description, R.drawable.sander_handheld_01, R.drawable.thumbnail_sander_handheld_01));
                tools.add(new Tool("Devil Finishing Sander", "$75", new String[] {"Finishing", "1/4 Sheet"}, description, R.drawable.sander_handheld_01, R.drawable.thumbnail_sander_handheld_01));
                tools.add(new Tool("Devil Random Orbital Sander", "$105", new String[] {"Random Orbital", "6\""}, description, R.drawable.sander_handheld_01, R.drawable.thumbnail_sander_handheld_01));
                tools.add(new Tool("Acme Corner Sander", "$115", new String[] {"Corner"}, description, R.drawable.sander_handheld_01, R.drawable.thumbnail_sander_handheld_01));
                tools.add(new Tool("Bullet Corner Sander", "$120", new String[] {"Corner"}, description, R.drawable.sander_handheld_01, R.drawable.thumbnail_sander_handheld_01));
                tools.add(new Tool("Couch Finishing Sander", "$150", new String[] {"Finishing ", "1/4 Sheet"}, description, R.drawable.sander_handheld_01, R.drawable.thumbnail_sander_handheld_01));
                tools.add(new Tool("Devil Random Orbital Sander", "$190", new String[] {"Random Orbital", "6\""}, description, R.drawable.sander_handheld_01, R.drawable.thumbnail_sander_handheld_01));
                tools.add(new Tool("Acme Belt Sander", "$240", new String[] {"Belt", "3\""}, description, R.drawable.sander_handheld_01, R.drawable.thumbnail_sander_handheld_01));
                tools.add(new Tool("Bullet Belt Sander", "$295", new String[] {"Belt", "4\""}, description, R.drawable.sander_handheld_01, R.drawable.thumbnail_sander_handheld_01));
                return tools;
        }
        return getGenericToolList(R.drawable.hero_image_sander);
    }

    private static List<Tool> getLathes(ToolTab toolTab) {
        final List<Tool> tools = new ArrayList<>();
        final String description = "Whether you're making pens, bowls, or table legs, this lathe will get the job done. A powerful motor allows you to turn even the toughest of woods with ease. The variable speed allows you to control exactly how you work on a custom piece, keeping your work accurate and safe.";
        tools.add(new Tool("Bacon Mini Lathe", "$325", new String[] {"1/2 HP", "10\" x 15\""}, description, R.drawable.hero_image_lathe, R.drawable.thumbnail_lathe_01));
        tools.add(new Tool("Dab Small Lathe", "$375", new String[] {"1/2 HP", "10\" x 20\""}, description, R.drawable.hero_image_lathe, R.drawable.thumbnail_lathe_01));
        tools.add(new Tool("Castle Lathe", "$455", new String[] {"3/4 HP", "12\" x 42\""}, description, R.drawable.hero_image_lathe, R.drawable.thumbnail_lathe_01));
        tools.add(new Tool("Dab Bench Lathe", "$525", new String[] {"3/4 HP", "12\" x 42\""}, description, R.drawable.hero_image_lathe, R.drawable.thumbnail_lathe_01));
        tools.add(new Tool("Acme Bench Lathe", "$555", new String[] {"1 HP", "14\" x 48\""}, description, R.drawable.hero_image_lathe, R.drawable.thumbnail_lathe_01));
        tools.add(new Tool("Dab Lathe and Stand", "$600", new String[] {"1 HP", "14\" x 48\""}, description, R.drawable.hero_image_lathe, R.drawable.thumbnail_lathe_01));
        tools.add(new Tool("Dab Variable Speed Lathe", "$640", new String[] {"1 HP", "14\" x 48\""}, description, R.drawable.hero_image_lathe, R.drawable.thumbnail_lathe_01));
        tools.add(new Tool("Acme Lathe", "$700", new String[] {"1 HP", "16\" x 56\""}, description, R.drawable.hero_image_lathe, R.drawable.thumbnail_lathe_01));
        tools.add(new Tool("Bacon 16\" x 56\" Lathe", "$780", new String[] {"1 HP", "16\" x 56\""}, description, R.drawable.hero_image_lathe, R.drawable.thumbnail_lathe_01));
        tools.add(new Tool("Castle Extended Lathe", "$914", new String[] {"2 HP", "20\" x 80\""}, description, R.drawable.hero_image_lathe, R.drawable.thumbnail_lathe_01));
        return tools;
    }

    private static List<Tool> getGenericToolList(@DrawableRes int imageResourceId) {
        final List<Tool> tools = new ArrayList<>();
        tools.add(new Tool("A gadget", "$25", new String[] {"Flexible", "Awesome"}, "This is a flexible awesome gadget. How could you live without one?", imageResourceId, imageResourceId));
        tools.add(new Tool("A doodad", "$75", new String[] {"Flexible", "Awesome"}, "This is a flexible awesome doodad. How could you live without one?", imageResourceId, imageResourceId));
        tools.add(new Tool("A whatsit", "$125", new String[] {"Flexible", "Awesome"}, "This is a flexible awesome whatsit. How could you live without one?", imageResourceId, imageResourceId));
        tools.add(new Tool("A thingamajig", "$15", new String[] {"Flexible", "Awesome"}, "This is a flexible awesome thingamajig. How could you live without one?", imageResourceId, imageResourceId));
        tools.add(new Tool("A contraption", "$525", new String[] {"Flexible", "Awesome"}, "This is a flexible awesome contraption. How could you live without one?", imageResourceId, imageResourceId));
        tools.add(new Tool("A gizmo", "$50", new String[] {"Flexible", "Awesome"}, "This is a flexible awesome gizmo. How could you live without one?", imageResourceId, imageResourceId));
        tools.add(new Tool("A doohickey", "$64", new String[] {"Flexible", "Awesome"}, "This is a flexible awesome doohickey. How could you live without one?", imageResourceId, imageResourceId));
        tools.add(new Tool("A widget", "$98", new String[] {"Flexible", "Awesome"}, "This is a flexible awesome widget. How could you live without one?", imageResourceId, imageResourceId));
        tools.add(new Tool("A contrivance", "$545", new String[] {"Flexible", "Awesome"}, "This is a flexible awesome contrivance. How could you live without one?", imageResourceId, imageResourceId));
        tools.add(new Tool("A machine", "$914", new String[] {"Flexible", "Awesome"}, "This is a flexible awesome machine. How could you live without one?", imageResourceId, imageResourceId));
        return tools;
    }
}
