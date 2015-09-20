package com.auidbook.prototype;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/**
 * Creates Tool objects with test data.
 *
 * @author Ian G. Clifton
 */
public class ToolTestUtils {

    private static final String[] BRANDS = {
            "Ace", "Bosch", "DeWalt", "Irwin", "Jet", "Kreg",
            "Makita", "Porter Cable", "Skil", "Stanley", "Stihl",
    };

    private static final String[] DETAILS_HP = {
            "1/4 HP", "1/2 HP", "3/4 HP", "1 HP", "1 1/2 HP", "2 HP",
    };

    private static final String[] DETAILS_CLAMP_TYPE = {
            "Bar", "Spring", "Quick-Grip", "Pipe", "Parallel",
    };

    private static final String[] DETAILS_INCHES = {
            "2\"", "5\"", "12\"", "18\"", "24\"", "36\"", "48\"",
    };

    private static final String[] DETAILS_BATTERY = {
            "12V", "18V", "20V", "24V", "32V", "48V",
    };

    private static final String[] DETAILS_BLADE_SIZE = {
            "7.25\" Blade", "10\" Blade", "12\" Blade"
    };

    private static final String[] PRICE_LOW = {
            "$2", "$5", "$12", "$15", "$20", "$22", "$25",
    };

    private static final String[] PRICE_MEDIUM = {
            "$75", "$100", "$120", "$150", "$160", "$200", "$225",
    };

    private static final String[] PRICE_HIGH = {
            "$375", "$400", "$420", "$450", "$535", "$570", "$625",
    };

    private static final String[] TYPES_SAWS_STATIONARY = {
            "Table Saw", "Miter Saw", "Chop Saw",
    };

    private static final String[] TYPES_SAWS_NOT_STATIONARY = {
            "Circular Saw", "Jig Saw", "Reciprocating Saw",
    };

    private static final String[] TYPES_DRILLS_STATIONARY = {
            "Bench Mount Drill Press", "Floor Mount Drill Press",
    };

    // ... You get the idea

    private final Random mRandom;

    public ToolTestUtils() {
        this(0);
    }

    public ToolTestUtils(long seed) {
        mRandom = new Random(seed);
    }

    public Tool getNewTool(ToolType toolType, ToolPagerAdapter.Tab tab) {
        final String brand = getRandom(BRANDS);
        String name = brand + " ";
        String price = null;
        final String[] details = new String[3];
        switch (toolType) {
            case CLAMPS:
                details[0] = getRandom(DETAILS_CLAMP_TYPE);
                details[1] = getRandom(DETAILS_INCHES);
                name += details[1] + " " + details[0] + " Clamp";
                details[1] +=  " opening";
                price = getRandom(PRICE_LOW);
                break;
            case SAWS:
                details[0] = getRandom(DETAILS_BLADE_SIZE);
                details[1] = getRandom(DETAILS_HP);
                if (tab == ToolPagerAdapter.Tab.BATTERY) {
                    details[2] = getRandom(DETAILS_BATTERY);
                }
                if (tab == ToolPagerAdapter.Tab.STATIONARY) {
                    name += getRandom(TYPES_SAWS_STATIONARY);
                } else {
                    name += getRandom(TYPES_SAWS_NOT_STATIONARY);
                }

                break;
            case DRILLS:
                details[0] = getRandom(DETAILS_HP);
                if (tab == ToolPagerAdapter.Tab.BATTERY) {
                    details[1] = getRandom(DETAILS_BATTERY);
                }
                if (tab == ToolPagerAdapter.Tab.STATIONARY) {
                    details[2] = getRandom(DETAILS_INCHES) + " throat";
                    name += getRandom(TYPES_DRILLS_STATIONARY);
                } else {
                    name += "Drill";
                }
                break;
            case SANDERS:
                name += "Sander";
                break;
            case ROUTERS:
                name += "Router";
                break;
            case MORE:
                name += "Tool";
                break;
        }

        if (price == null) {
            if (tab == ToolPagerAdapter.Tab.STATIONARY) {
                price = getRandom(PRICE_HIGH);
            } else {
                price = getRandom(PRICE_MEDIUM);
            }
        }

        String description = "The latest and greatest from " + brand + " takes " + toolType.name().toLowerCase(Locale.getDefault()) + " to a whole new level. Tenderloin corned beef tail, tongue landjaeger boudin kevin ham pig pork loin short loin shoulder prosciutto ground round. Alcatra salami sausage short ribs t-bone, tongue spare ribs kevin meatball tenderloin. Prosciutto tail meatloaf, chuck pancetta kielbasa leberkas tenderloin drumstick meatball alcatra cow sausage corned beef pork belly. Shoulder swine hamburger tail ham hock bacon pork belly leberkas beef ribs jowl spare ribs.";

        return new Tool(name, price, details, description);
    };

    public ArrayList<Tool> getNewTools(ToolType toolType, ToolPagerAdapter.Tab tab, int count) {
        final ArrayList<Tool> results = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            results.add(getNewTool(toolType, tab));
        }
        return results;
    };

    private String getRandom(String[] strings) {
        return strings[mRandom.nextInt(strings.length)];
    }

}