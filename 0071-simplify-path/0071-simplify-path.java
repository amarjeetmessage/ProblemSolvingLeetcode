class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");   // Split by '/'
        Stack<String> stack = new Stack<>();

        for (String i : arr) {
            if (i.equals("..") && !stack.isEmpty()) {  // Go one directory up
                stack.pop();
            } else if (!i.equals("") && !i.equals(".") && !i.equals("..")) {
                stack.push(i);  // Add valid directory name
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/");
            sb.append(dir);
        }

        // If stack is empty, return root "/"
        return sb.length() == 0 ? "/" : sb.toString();
    }
}