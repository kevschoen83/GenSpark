
class Problem {
    public static void main(String[] args) {
        String solution = "default";
        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 0) {
                if ("mode".equals(args[i])) {
                    solution = args[i + 1];
                }
            }
        }
        System.out.println(solution);
    }
}
