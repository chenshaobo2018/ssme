package cn.chen.oa.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo2_Prize {

	/**
	 * 一 根据设置的概率产生[0,3]之间的随机数
	 * @param args
	 */
	public static void main(String[] args) {
		//1.随机数的概率设置
		List<Integer> weight = new ArrayList<Integer>();//这个list集合是装的权重
		weight.add(80);//0，产生随机数0的概率
		weight.add(10);//1，产生随机数1的概率
		weight.add(0);//2，产生随机数2的概率
		weight.add(10);//3，产生随机数3的概率
		
		//2.测试产生随机数
		for (int i = 0; i < 50; i++) {
			int random = random(weight);//残生随机数
			System.out.println(random);
		}
	}

	
	/**
	 * 二 权重随机数:产生从0开始的随机数，权重由自己设计
	 * 
	 * @param weight 权重
	 * @return [0,3]的随机数
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
	    int index = 0;
	    for(int i = weightTmp.size()-1; i >0; i--){
	        if( rand >= weightTmp.get(i)){
	            index = i;
	            break;
	        }
	    }
	    return index;
	}
}