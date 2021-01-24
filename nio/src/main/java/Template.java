import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;  //只能使用最高1.8版本JDK提供的API
import java.util.stream.IntStream;


/**
 * 题目：给定一个字符串（只包含小写英文字母），按顺序执行以下两条规则，输出计算后的字符串。
 *
 * 规则 1：对于连续顺序4位及以上的字母，中间使用“~”替换。
 * 例如：ahhhhhhbcdefko, 替换后为ahhhhhhb~fko。
 *
 * 规则2：对于连续重复出现3个及以上的字母，以该字母+重复的个数替换。
 * 例如：ahhhhhhbcdefko，替换后为ah6bcdefko。
 *
 * 总体示例：
 * 输入字符串为：ahhhhhhbcdefko     结果为：ah6b~fko
 * 输入字符串为：ahhhhhhbcdefko     结果为：ah6b~fko
 * 输入字符串为：ammmmmnopqko       结果为：am5~qko
 * 输入字符串为：abcdefffffadfasdfa 结果为：a~f5adfasdfa
 * 输入字符串为：mnopqqqrstabs      结果为：m~q3~tabs
 * 输入字符串为：xyzabcd 			  结果为：xyza~d
 *
 * 提示：
 * 1. 规则按规则1，规则2顺序执行。先执行1，后执行2。
 * 2. 请注意边界值的考虑，注意连续出现条件匹配的情况。
 * 3. 请注意字符串拼接的性能消耗。
 * 4. 请先花一定时间理清思路在再编写代码。
 * 5. 可以试着把上面总体实例中的例子跑正确后再提交。
 *
 */
public class Template { //类名不可修改!!!
	/**
	 * 程序逻辑请在该方法中完成
	 *
	 * 注意：
	 * 1. 方法名、参数个数及类型不可更改，只可修改函数体!!!
	 * 2. 提交文件时，保证包路径package com.yinhai.onehour
	 *
	 * @param inData 参数 验证程序通过该参数传入字符串
	 * @return 返回值 验证程序通过该返回值验证程序正确性
	 */
	public String methodTest(String inData){
		String outData = "";
		// 实现逻辑
		String pre = "";
		String str = Arrays.asList(inData.split(""))
				.stream()
				.reduce((cur, acc) -> acc).get();
		// outData = myMethod(inData); // 可添加自己的函数
		ArrayList<Integer> a = new ArrayList();
		a.toArray(new Integer[8]);
		return outData;
	}


	/**
	 * 可修改，验证自己的答案
	 * @param args
	 */
	public static void main(String[] args) throws ParseException {
		// 用于自己校验结果
		Template template = new Template();
		long startTime = System.currentTimeMillis();
		char a = 'A';
//        System.out.println(Integer.toBinaryString(0xdf));

        String S = "ab";
		for(int i=0;i<S.length()-1;i++) {
			if (S.charAt(i) != S.charAt(i + 1)) {
				System.out.println(1);
			}
		}


//        for (; a <= 'z'; ++a) {
//            System.out.println(Integer.toBinaryString(a));
//            System.out.println(Integer.toBinaryString(a & 0xdf));
//            System.out.println((a & 0xdf) + " " + a + " " + (int) a);
//            System.out.println("-------------------------------------");
//        }
		String result = template.methodTest("abcdefko");
		long endTime = System.currentTimeMillis();
		System.out.println("耗时(毫秒)：" + (endTime - startTime));

        List<Integer> aae002Ke27 = new LinkedList<Integer>(){{add(3);add(4);add(5);}};
		List<Integer> aae002Ke27k2 = new LinkedList<Integer>(){{add(1);add(2);add(3);add(4);add(5);}};
		aae002Ke27k2.retainAll(aae002Ke27);
		System.out.println(aae002Ke27);

		System.out.println(Arrays.toString(IntStream.range(0, 3).toArray()));
		System.out.println("2020-10-22 00:00:00至".replaceAll("^([0-9- :]+).*", "$1"));
		System.out.println("2020-10-22 00:00:00至2020-12-01 00:00:00".replaceAll("^([0-9- :]+).*", "$1"));
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(smf.parse("2020-10-22 00:00:00"));
	}
}
