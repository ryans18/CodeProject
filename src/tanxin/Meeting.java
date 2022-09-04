package tanxin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author：Ryans
 * Date：Created in 2022/9/3 18:30
 * Introduction：贪心算法-会议最多问题
 * 会议室一次最多安排一个项目，每个项目起始时间和结束时间不一样，求安排最多项目多少场
 * 贪心策略：按最早结束时间
 */
public class Meeting {

    private static class Program {
        int start;
        int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class ProgramComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    private static int bestArrange(Program[] programs, int time) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (Program program : programs) {
            if (time <= program.start) {
                result++;
                time = program.end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Program[] programs = new Program[]{
            new Program(6, 8),new Program(7, 10),new Program(8, 9),new Program(10, 15),new Program(14, 15)
        };
        
        System.out.println(bestArrange(programs, 6));
    }
}