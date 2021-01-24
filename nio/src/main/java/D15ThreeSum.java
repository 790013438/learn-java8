import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName PACKAGE_NAME
 * Company: com.yinhai
 * date 2020/5/29

 */
public class D15ThreeSum {
    private static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result.append(number).append(", ");
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    private static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    private static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list : nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Integer> numsList = Arrays.stream(args)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int[] nums = new int[args.length];
        for (int li = 0; li < numsList.size(); ++li) {
            nums[li] = numsList.get(li);
        }

        List<List<Integer>> ret = new D15ThreeSum().threeSum(nums);

        String out = int2dListToString(ret);

        System.out.print(out);
    }

    private List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        // negSize：负数的数量
        // posSize：正数的数量
        // zeroSize：0的数量
        int negSize = 0, posSize = 0, zeroSize = 0;
        int[] negs = new int[nums.length];
        int[] poses = new int[nums.length];
        for (int v : nums) {
            if (v < minValue) {
                minValue = v;
            }
            if (v > maxValue) {
                maxValue = v;
            }
            if (v > 0) {
                poses[posSize] = v;
                posSize++;
            } else if (v < 0) {
                negs[negSize] = v;
                negSize++;
            } else {
                zeroSize++;
            }
        }
        // 超过3个0
        if (zeroSize >= 3) {
            res.add(Arrays.asList(0, 0, 0));
        }
        // 如果没有负数或没有正数
        if (negSize == 0 || posSize == 0) {
            return res;
        }

        // 如果max/min的绝对值超过了另一边的两倍，将其设置为另一边的两倍，省掉了超界的部分
        if ((minValue << 1) + maxValue > 0) {
            maxValue = -minValue << 1;
        } else if ((maxValue << 1) + minValue < 0) {
            minValue = -maxValue << 1;
        }

        // 类似游标数组，n对应下标为n-minValue
        int[] map = new int[maxValue - minValue + 1];
        for (int v : nums) {
            if (v < minValue || v > maxValue) {
                continue;
            }
            map[v - minValue]++;
            //每个位置存放数组中对应数字的个数,poses和negs存放正、负数
        }
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int nv = 0;
        //遍历负数数组
        // -1 0 1 2 -1 -4
        // 1 1 -2
        // [4,0,2,3,-1] 4 0 2 3 -1
        // [0,3,2,4,-3,-1,-4,-3,-3,2] 0 3 2 4 -3 -1 -4 -3 -3 2
        for (int i = negSize - 1; i >= 0; i--) {
            // 跳过遍历找过了的负数
            if (nv == negs[i]) {
                continue;
            }
            nv = negs[i];
            // 正数值，需要的值
            int pv = 0, cv;
            for (int j = 0; j < posSize; ++j) {
                // 跳过遍历找过了的正数
                if (pv == poses[j]) {
                    continue;
                }
                pv = poses[j];
                cv = 0 - (nv + pv);
                while (j < posSize && cv - minValue > -1 && cv - minValue < map.length && map[cv - minValue] == 0) {
                    ++j;
                    pv = poses[j];
                    cv = 0 - (nv + pv);
                }
                // 负数有重复2次以上
                if (cv == nv && map[nv - minValue] > 1) {
                    res.add(Arrays.asList(nv, cv, pv));
                } else if (cv == pv && map[pv - minValue] > 1) {
                    // 正数有重复2次以上
                    res.add(Arrays.asList(nv, cv, pv));
                } else if (cv > nv && cv < pv && map[cv - minValue] > 0) {
                    // 在正负之间
                    res.add(Arrays.asList(nv, cv, pv));
                }
            }

        }
        return res;
    }
}
