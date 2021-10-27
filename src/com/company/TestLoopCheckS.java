package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TestLoopCheckS {
	private static HashMap<String, ArrayList<String>> map =null ;
	private final static HashSet<String> DeadCycleSet;

	//Student target = map.get("Xiao Ming");
	static {
		 DeadCycleSet=new HashSet<>();
		 map=new HashMap<String, ArrayList<String>>();
		 /*ArrayList<String> arrayList = new ArrayList<String>();
		 arrayList.add("chain9");
		 ArrayList<String> arrayList2 = new ArrayList<String>();
		 arrayList2.add("chain9");
		 arrayList3.add("chain9");
		 ArrayList<String> arrayList9 = new ArrayList<String>();
		 arrayList9.add("chain5");
		 arrayList9.add("chain2");
		 map.put("chain1", arrayList );
		 map.put("chain2", arrayList2 );
		 map.put("chain3", arrayList3 );e
		 map.put("chain9", arrayList9);
		 map.put("chain5", new ArrayList<String>());
		 map.put("chain6", new ArrayList<String>());*/
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("chain2");
		//arrayList.add("chain3");
		ArrayList<String> arrayList2 = new ArrayList<String>();
		arrayList2.add("chain3");
		ArrayList<String> arrayList3 = new ArrayList<String>();
		arrayList3.add("chain4");
		//arrayList3.add("chain6");
		ArrayList<String> arrayList4 = new ArrayList<String>();
		//arrayList9.add("chain2");
		arrayList4.add("chain9");
		ArrayList<String> arrayList5 = new ArrayList<String>();
		arrayList5.add("chain7");
		ArrayList<String> arrayList6 = new ArrayList<String>();
		arrayList6.add("chain5");
		ArrayList<String> arrayList7 = new ArrayList<String>();
		arrayList7.add("chain10");
		ArrayList<String> arrayList10 = new ArrayList<String>();
		arrayList10.add("chain3");
		map.put("chain9", arrayList );
		map.put("chain2", arrayList2 );
		map.put("chain3", arrayList3 );
		map.put("chain4", arrayList4);
		map.put("chain5", arrayList5);
		map.put("chain6", arrayList6);
		map.put("chain7", arrayList7);
		map.put("chain10", arrayList10);
		//map.put("chain5", new ArrayList<String>());
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
				System.out.println("==================================");
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
			//add
			if((!(DeadCycleSet == null || DeadCycleSet.size() == 0))&&DeadCycleSet.contains(chainName)){
				    AddDeadCycleSet(DeadCycleSet,parentchain);
					result = true;
					return result;
			}else{
				for (String innerChainName : innerChainNameList) {
					ArrayList<String> list = new ArrayList<>();
					if (parentchain.size() > 0) {
						list.addAll(parentchain);
					}
					if (list.contains(innerChainName)) {
						list.add(innerChainName);
						//add 所有错误链节点
						AddDeadCycleSet(DeadCycleSet,list);
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
		}

		return result;
	}


	public static void AddDeadCycleSet(HashSet<String> deadCycleList, ArrayList<String> deadChain){
		System.out.println("链路执行至"+deadChain+"，死循环节点为"+deadChain.get(deadChain.size()-1));
		deadCycleList.addAll(deadChain);
	    System.out.println("当前已存在死循环链路："+deadCycleList);
   }



	public static void main(String[] args) {

		boolean checkChain = checkChain(TestLoopCheckS.map);
		System.out.println("校验完毕");


	}

}