package cn.chen.oa.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test1 {

	public static void main(String[] args) {
//		List<Integer> weight = new ArrayList<Integer>();//这个list集合是装的权重
//		weight.add(10);//0
//		weight.add(10);//1
//		weight.add(0);//2
//		weight.add(10);//3
////		weight.add(10);//4
////		weight.add(10);//5
////		weight.add(10);//6
////		weight.add(10);//7
//		for (int i = 0; i < 50; i++) {
//			int random = random(weight);
//			System.out.println(random);
//		}

		
		
		//---------------------------
//		System.out.println(new Double(15.8));
//		System.out.println(15.8);
		
		//---------------------------
		String a[][][]= {{{"卫浴"},{"独立卫浴","有浴"},{"无立卫浴","无浴"}},{{"卫浴2"},{"独立卫浴2","有浴2"},{"无立卫浴2","无浴2"}}};
		String allStr = "[";
		for (String[][] is : a) {
			allStr = allStr + "{";
			for (String[] i : is) {
				allStr = allStr + "{";
				for (String str : i) {
					System.out.print(str+"--");
				}
				allStr = allStr + "},";
			}
			allStr = allStr + "},";
		}
		allStr = allStr + "]";
		System.out.println(allStr);
	}
	
	/**
	 * 权重随机数:产生从1开始的随机数，权重由自己设计
	 * 
	 * @return 随机数
	 */
	public static int random(List<Integer> weight){
		//构造一个有初始容量的列表，初始容量为权重列表容量+1，作为区间
	    List<Integer> weightTmp = new ArrayList<Integer>(weight.size()+1);
	    weightTmp.add(0);
	    Integer sum = 0;
	    for( Integer d : weight ){
	        sum += d;
	        weightTmp.add(sum);
	    }
	    Random random = new Random();
	    int rand = random.nextInt(sum);//产生[0,sum)的随机数
	    int index = 0;//随机数的起始值
	    for(int i = weightTmp.size()-1; i >0; i--){
	        if( rand >= weightTmp.get(i)){
	            index = i;//在第几次循环执行的这句代码，就返回第几次循环数，
	            break;
	        }
	    }
	    return index;
	}
}