package Week13;

public class Main {
    public static void main(String[] args) {
        // ProjectTree projectTree = new ProjectTree();

        // // Adding the main project
        // projectTree.addMainProject("MainProject");

        // // Adding sub-projects
        // projectTree.setLeftSubProject("MainProject", "SubProject1");
        // projectTree.setRightSubProject("MainProject", "SubProject2");
        // projectTree.setLeftSubProject("SubProject1", "SubSubProject1");
        // projectTree.setRightSubProject("SubProject1", "SubSubProject2");
        // projectTree.setLeftSubProject("SubSubProject1", "SubSubSubProject1");
        // projectTree.setLeftSubProject("SubProject2", "SubSubProject3");
        // projectTree.setRightSubProject("SubProject2", "SubSubProject4");

        // // Calculating results
        // System.out.println("Total Projects: " + projectTree.getTotalProjects());
        // System.out.println("Longest Path: " + projectTree.getLongestPath());
        // System.out.println("Leaf Projects: " + projectTree.getLeafProjects());

        ProjectTree projectTree1 = new ProjectTree();
        projectTree1.addMainProject("MainProject");
        projectTree1.setLeftSubProject("MainProject", "SubProject1");
        projectTree1.setRightSubProject("MainProject", "SubProject2");
        projectTree1.setLeftSubProject("SubProject1", "SubSubProject1");
        projectTree1.setRightSubProject("SubProject1", "SubSubProject2");
        projectTree1.setLeftSubProject("SubProject2", "SubSubProject3");

        System.out.println("Total Projects: " + projectTree1.getTotalProjects());
        System.out.println("Longest Path: " + projectTree1.getLongestPath());
        System.out.println("Leaf Projects: " + projectTree1.getLeafProjects());

        ProjectTree projectTree2 = new ProjectTree();
        projectTree2.addMainProject("MainProject");
        projectTree2.setLeftSubProject("MainProject", "SubProject1");
        projectTree2.setRightSubProject("MainProject", "SubProject2");
        projectTree2.setLeftSubProject("SubProject1", "SubSubProject1");
        projectTree2.setLeftSubProject("SubSubProject1", "SubSubSubProject1");
        projectTree2.setLeftSubProject("SubProject2", "SubSubProject3");
        projectTree2.setRightSubProject("SubProject2", "SubSubProject4");

        System.out.println("\nTotal Projects: " + projectTree2.getTotalProjects());
        System.out.println("Longest Path: " + projectTree2.getLongestPath());
        System.out.println("Leaf Projects: " + projectTree2.getLeafProjects());
    }
}