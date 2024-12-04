package Week13;

// import java.util.*;

class ProjectNode {
    private String name;
    private String leftSubProjectName;
    private String rightSubProjectName;

    public ProjectNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLeftSubProjectName() {
        return leftSubProjectName;
    }

    public void setLeftSubProjectName(String left) {
        this.leftSubProjectName = left;
    }

    public String getRightSubProjectName() {
        return rightSubProjectName;
    }

    public void setRightSubProjectName(String right) {
        this.rightSubProjectName = right;
    }
}

