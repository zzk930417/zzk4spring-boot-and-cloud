package com.test.eurekaClient.test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import com.alibaba.fastjson.JSON;

/**
 * 在开发中，相信OOM异常都有遇到过，当遇到大对象的时候，该怎么处理，接下来所讲的强引用，软引用，弱引用，虚引用希望能给你一些启发。
 * @author Administrator
 *
 */
public class Reference {

	/**
	 * 强引用就是指在程序代码之中普遍存在的，比如下面这段代码中的object和str都是强引用：
	 * 只要某个对象有强引用与之关联，JVM必定不会回收这个对象，即使在内存不足的情况下，JVM宁愿抛出OutOfMemory错误也不会回收这种对象。
	 * 比如下面这段代码: 当运行至Object[] objArr = new
	 * Object[1000];这句时，如果内存不足，JVM会抛出OOM错误也不会回收object指向的对象。不过要注意的是，当fun1运行完之后，
	 * object和objArr都已经不存在了，所以它们指向的对象都会被JVM回收。
	 * 
	 * 如果想中断强引用和某个对象之间的关联，可以显示地将引用赋值为null，这样一来的话，JVM在合适的时间就会回收该对象。
	 * 
	 * 比如Vector类的clear方法中就是通过将引用赋值为null来实现清理工作的：
	 */
	private static void strongReference() {
		Object object = new Object();
		String aa = "strongReference hello 科兴";
		Object[] objArr = new Object[1000];
		// 赋值null来说明对象已无强引用，gc会及时回收对象，释放空间
		objArr = null;
	}
	
	
	/**
	 * 软引用
	 * 软引用是用来描述一些有用但并不是必需的对象，在Java中用java.lang.ref.SoftReference类来表示。对于软引用关联着的对象，
	 * 只有在内存不足的时候JVM才会回收该对象。因此，这一点可以很好地用来解决OOM的问题，并且这个特性很适合用来实现缓存：比如网页缓存、图片缓存等。
	 * 
	 * 软引用可以和一个引用队列（ReferenceQueue）联合使用，如果软引用所引用的对象被JVM回收，这个软引用就会被加入到与之关联的引用队列中。
	 * 下面是一个使用示例：
	 */
	private static void softReference() {
		SoftReference<String> sr = new SoftReference(new String("softReference hello 科兴"));
		System.out.println(sr.get());
		System.gc();
		System.out.println(sr.get());
 
	}
	
	/**
	 * 弱引用也是用来描述非必需对象的，当JVM进行垃圾回收时，无论内存是否充足，都会回收被弱引用关联的对象。在java中，用java.lang.ref.
	 * WeakReference类来表示。下面是使用示例：
	 * 
	 * @throws InterruptedException
	 */
	private static void weakReference() throws InterruptedException {
		ReferenceQueue referenceQueue = new ReferenceQueue();
		WeakReference weakReference = new WeakReference(new String("weakReference hello 科兴"), referenceQueue);
		System.out.println(weakReference.get());
		//System.gc();
		System.out.println(weakReference.get());
		System.out.println(JSON.toJSON(referenceQueue.remove()));
	}
	
	
	/**
	 * 虚引用和前面的软引用、弱引用不同，它并不影响对象的生命周期。在java中用java.lang.ref.PhantomReference类表示。
	 * 如果一个对象与虚引用关联，则跟没有引用与之关联一样，在任何时候都可能被垃圾回收器回收。
	 * 
	 * 要注意的是，虚引用必须和引用队列关联使用，当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，就会把这个虚引用加入到与之
	 * 关联的引用队列中。程序可以通过判断引用队列中是否已经加入了虚引用，来了解被引用的对象是否将要被垃圾回收。如果程序发现某个虚引用已经被加入到引用队列
	 * ，那么就可以在所引用的对象的内存被回收之前采取必要的行动。
	 */
	private static void phantomReference() {
		ReferenceQueue referenceQueue = new ReferenceQueue();
		PhantomReference phantomReference = new PhantomReference(new String("phantomReference hello 科兴"),
				referenceQueue);
		System.out.println(phantomReference.get());
	}
	
	
	public static void main(String[] args) {
		try {
			weakReference();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
