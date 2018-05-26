import groovy.beans.Bindable;
import groovy.lang.Binding;
import groovy.lang.Closure;
import groovy.lang.Script;
import groovy.swing.SwingBuilder;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class MyModel {
    public void addPropertyChangeListener(PropertyChangeListener listener) {//todo
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {//todo
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {//todo
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {//todo
    }

    public void firePropertyChange(String name, Object oldValue, Object newValue) {//todo
    }

    public PropertyChangeListener[] getPropertyChangeListeners() {//todo
    }

    public PropertyChangeListener[] getPropertyChangeListeners(String name) {//todo
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getNumOfStops() {
        return numOfStops;
    }

    public void setNumOfStops(int numOfStops) {
        this.numOfStops = numOfStops;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    @Bindable
    private int floor = 0;
    @Bindable
    private User user = new User(6, 4);
    @Bindable
    private int numOfStops = 2;
    @Bindable
    private Elevator elevator = new Elevator(numOfStops, false, 4, new ArrayList<Integer>(Arrays.asList(3, 1)));
}

public class Interface extends Script {
    public static void main(String[] args) {
        new Interface(new Binding(args)).run();
    }

    public Object run() {


        final MyModel model = new MyModel();
        return new SwingBuilder().edt(new Closure<JFrame>(this, this) {
            public JFrame doCall(Object it) {
                LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>(4);
                map.put("title", "Java Frame");
                map.put("size", new ArrayList<Integer>(Arrays.asList(800, 600)));
                map.put("locationRelativeTo", null);
                map.put("show", true);
                return frame(map, new Closure<JButton>(Interface.this, Interface.this) {
                    public JButton doCall(Object it) {

                        //model.user.desiredFloor = model.floor
                        final Calculations calculations = new Calculations(model.getUser(), model.getElevator());
                        LinkedHashMap<String, Object> map1 = new LinkedHashMap<String, Object>(1);
                        LinkedHashMap<String, Serializable> map2 = new LinkedHashMap<String, Serializable>(3);
                        map2.put("source", getProperty("model"));
                        map2.put("sourceProperty", "floor");
                        map2.put("converter", new Closure<String>(this, this) {
                            public String doCall(Object v) {
                                return v ? "Time to  " + String.valueOf(v) + " floor: " + String.valueOf(getProperty("calculations").invokeMethod("getElevatorTime", new Object[]{getProperty("model").numOfStops, getProperty("model").floor})) : "";
                            }

                        });
                        map1.put("text", invokeMethod("bind", new Object[]{map2}));
                        label(map1);
                        LinkedHashMap<String, Integer> map3 = new LinkedHashMap<String, Integer>(2);
                        map3.put("cols", 3);
                        map3.put("rows", 2);
                        gridLayout(map3);
                        LinkedHashMap<String, Closure<Integer>> map4 = new LinkedHashMap<String, Closure<Integer>>(1);
                        map4.put("actionPerformed", new Closure<Integer>(this, this) {
                            public Integer doCall(Object it) {
                                return getProperty("model").floor = 1;
                            }

                            public Integer doCall() {
                                return doCall(null);
                            }

                        });
                        button(map4, "Floor 1");
                        LinkedHashMap<String, Closure<Integer>> map5 = new LinkedHashMap<String, Closure<Integer>>(1);
                        map5.put("actionPerformed", new Closure<Integer>(this, this) {
                            public Integer doCall(Object it) {
                                return getProperty("model").floor = 2;
                            }

                            public Integer doCall() {
                                return doCall(null);
                            }

                        });
                        button(map5, "Floor 2");
                        LinkedHashMap<String, Closure<Integer>> map6 = new LinkedHashMap<String, Closure<Integer>>(1);
                        map6.put("actionPerformed", new Closure<Integer>(this, this) {
                            public Integer doCall(Object it) {
                                return getProperty("model").floor = 3;
                            }

                            public Integer doCall() {
                                return doCall(null);
                            }

                        });
                        button(map6, "Floor 3");
                        LinkedHashMap<String, Closure<Integer>> map7 = new LinkedHashMap<String, Closure<Integer>>(1);
                        map7.put("actionPerformed", new Closure<Integer>(this, this) {
                            public Integer doCall(Object it) {
                                return getProperty("model").floor = 4;
                            }

                            public Integer doCall() {
                                return doCall(null);
                            }

                        });
                        button(map7, "Floor 4");
                        LinkedHashMap<String, Closure<Integer>> map8 = new LinkedHashMap<String, Closure<Integer>>(1);
                        map8.put("actionPerformed", new Closure<Integer>(this, this) {
                            public Integer doCall(Object it) {
                                return getProperty("model").floor = 5;
                            }

                            public Integer doCall() {
                                return doCall(null);
                            }

                        });
                        button(map8, "Floor 5");
                        LinkedHashMap<String, Closure<Integer>> map9 = new LinkedHashMap<String, Closure<Integer>>(1);
                        map9.put("actionPerformed", new Closure<Integer>(this, this) {
                            public Integer doCall(Object it) {
                                return getProperty("model").floor = 6;
                            }

                            public Integer doCall() {
                                return doCall(null);
                            }

                        });
                        return button(map9, "Floor 6");
                    }

                    public JButton doCall() {
                        return doCall(null);
                    }

                });


            }

            public JFrame doCall() {
                return doCall(null);
            }

        });


    }

    public Interface(Binding binding) {
        super(binding);
    }

    public Interface() {
        super();
    }
}
