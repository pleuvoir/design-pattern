package io.github.pleuvoir.visitor.bestpractice;

import java.util.Arrays;
import java.util.List;

import io.github.pleuvoir.visitor.bestpractice.payload.Content;
import io.github.pleuvoir.visitor.bestpractice.payload.item.ImageContentItem;
import io.github.pleuvoir.visitor.bestpractice.payload.item.TextContentItem;
import io.github.pleuvoir.visitor.bestpractice.visitor.ConcretVisitor;
import io.github.pleuvoir.visitor.bestpractice.visitor.Visitor;

public class Client {

	public static void main(String[] args) {

		ConcretVisitor concretVisitor = new ConcretVisitor();
		List<Content> contentList = Arrays.asList(new ImageContentItem(), new TextContentItem(), new Content() {
			@Override
			public void accept(Visitor visitor) {
				System.out.println("呵呵前");
				visitor.visit(this);  // 这里就是每次遍历会被执行的方法
				System.out.println("呵呵后");
			}

			@Override
			public String type() {
				return "父类内容";
			}
		});

		
		for (Content content : contentList) {
			content.accept(concretVisitor);
		}
		
	}

}
