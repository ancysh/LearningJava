package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class TestLoopCheck {
	private static HashMap<String, ArrayList<String>> map =null ;






	static {
		map=new HashMap<String, ArrayList<String>>();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("chain2");
		arrayList.add("chain3");
		ArrayList<String> arrayList2 = new ArrayList<String>();
		arrayList2.add("chain9");
		ArrayList<String> arrayList3 = new ArrayList<String>();
		arrayList3.add("chain5");
		arrayList3.add("chain6");
		ArrayList<String> arrayList9 = new ArrayList<String>();
		arrayList9.add("chain2");
		arrayList9.add("chain6");
		map.put("chain7", arrayList );
		map.put("chain2", arrayList2 );
		map.put("chain3", arrayList3 );
		map.put("chain9", arrayList9);
		map.put("chain5", new ArrayList<String>());
		map.put("chain6", new ArrayList<String>());
	}

	public static boolean checkChain(HashMap<String, ArrayList<String>> map) {
		boolean result = false;

		for (String chainName : map.keySet()) {
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.add(chainName);
			boolean loopResult = deadLoopChainCheck(chainName, arrayList);
			if (!loopResult) {
				continue;
			} else {
				System.out.println(chainName + "中子链路中包含死循环调用");
			}

		}
		return result;

	}

	/*
	 * 死循环校验 true 存在死循环调用 false 不存在死循环调用
	 *
	 *
	 *
	 */
	public static boolean deadLoopChainCheck(String chainName, ArrayList<String> parentchain) {
		Boolean result = false;
		ArrayList<String> innerChainNameList = (ArrayList<String>) map.get(chainName);
		if (innerChainNameList.size() > 0) {
			ArrayList<String> list = new ArrayList<String>();
			if (parentchain.size() > 0) {
				list.addAll(parentchain);
			}
			for (String innerChainName : innerChainNameList) {

				if (list.contains(innerChainName)) {
					list.add(innerChainName);
					System.out.println(list);
					result = true;
					return result;
				} else {
					list.add(innerChainName);
					boolean flag = deadLoopChainCheck(innerChainName, list);
					if (flag) {
						result = true;
						break;
					} else {
						continue;
					}
				}
			}
		}

		return result;
	}






	public static void main(String[] args) {

		boolean checkChain = checkChain(TestLoopCheck.map);
		System.out.println("校验完毕");
	}

}