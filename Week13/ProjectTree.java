package Week13;

import java.util.*;

class ProjectTree {
    private Map<String, ProjectNode> nodeMap = new HashMap<>();
    private String rootName;

    public void addMainProject(String name) {
        ProjectNode root = new ProjectNode(name);
        nodeMap.put(name, root);
        rootName = name;
    }

    public void setLeftSubProject(String parNames, String spNames) {
        ProjectNode parentNode = nodeMap.get(parNames);
        if (parentNode != null) {
            parentNode.setLeftSubProjectName(spNames);
            nodeMap.put(spNames, new ProjectNode(spNames));
        }
    }

    public void setRightSubProject(String parNames, String spNames) {
        ProjectNode parentNode = nodeMap.get(parNames);
        if (parentNode != null) {
            parentNode.setRightSubProjectName(spNames);
            nodeMap.put(spNames, new ProjectNode(spNames));
        }
    }

    public int countTotalProjects(String nodNames) {
        if (nodNames == null || !nodeMap.containsKey(nodNames))
            return 0;
        ProjectNode node = nodeMap.get(nodNames);
        return 1 +
                countTotalProjects(node.getLeftSubProjectName()) +
                countTotalProjects(node.getRightSubProjectName());
    }

    public void findLongestPath(String nodNames, List<String> path, List<String> longestPath) {
        if (nodNames == null || !nodeMap.containsKey(nodNames))
            return;

        path.add(nodNames);
        ProjectNode node = nodeMap.get(nodNames);

        if (node.getLeftSubProjectName() == null && node.getRightSubProjectName() == null) {
            if (path.size() > longestPath.size()) {
                longestPath.clear();
                longestPath.addAll(path);
            }
        } else{
            findLongestPath(node.getLeftSubProjectName(), path, longestPath);
        findLongestPath(node.getRightSubProjectName(), path, longestPath);
        }

        path.remove(path.size() - 1);
    }

    public void findAllLeafProjects(String nodNames, List<String> leafProjects) {
        if (nodNames == null || !nodeMap.containsKey(nodNames))
            return;

        ProjectNode node = nodeMap.get(nodNames);

        if (node.getLeftSubProjectName() == null && node.getRightSubProjectName() == null) {
            leafProjects.add(nodNames);
        } else {
            findAllLeafProjects(node.getLeftSubProjectName(), leafProjects);
            findAllLeafProjects(node.getRightSubProjectName(), leafProjects);
        }
    }

    // Helper methods to get results
    public int getTotalProjects() {
        return countTotalProjects(rootName);
    }

    public List<String> getLongestPath() {
        List<String> path = new ArrayList<>();
        List<String> longestPath = new ArrayList<>();
        findLongestPath(rootName, path, longestPath);
        return longestPath;
    }

    public List<String> getLeafProjects() {
        List<String> leafProjects = new ArrayList<>();
        findAllLeafProjects(rootName, leafProjects);
        return leafProjects;
    }
}
