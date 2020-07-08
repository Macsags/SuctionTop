
SuctionTop
====

简介：
-------
吸顶、粘顶、顶部吸附</br>
****
示例：
-------
![](https://github.com/Macsags/SuctionTop/blob/master/yulan.gif)

[图片地址](https://github.com/Macsags/SuctionTop/blob/master/yulan.gif)
</br>
****
日志
-------
2020/6/22
* 第一次上传
****
如何使用How to：
-------
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle
maven
sbt
leiningen
Add it in your root build.gradle at the end of repositories:

```
allprojects { 
		repositories { 
			... 
			maven { url 'https://www.jitpack.io' } 
		} 
	}  		
```

Step 2. Add the dependency<br> 

```
allprojects { 
	dependencies {
	         implementation 'com.github.Macsags:SuctionTop:1.0.0'
	      } 
	} 
```	
****
使用方法：
-------
```
        private void initView() {
        final List<DataBean> mList = getList();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(this, mList);

        SuctionTop decoration = new SuctionTop(this) {
            @Override
            protected boolean isShowItemLabel(int position) {
                return mList.get(position).isShowLable();
            }

            @Override
            protected String getItemLabelStr(int position) {
                return mList.get(position).getSpell();
            }

            @Override
            protected int getItemLabelImg(int position) {
                return mList.get(position).getImgLable();
            }
        };

        //设置标签颜色
//        decoration.setLabelColor(Color.DKGRAY);
        //设置标签高度
//        decoration.setLabelHeight(30);
        //设置标签字体颜色
//        decoration.setTextColor(Color.RED);
        //设置标签字体大小
//        decoration.setTextSize(50);
        //设置标签字体居右
//        decoration.setLabelGravity(LABEL_GRAVITY_RIGHT);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(adapter);

    }

    private List<DataBean> getList() {
        List<DataBean> list = new ArrayList<>();
        // 序列、是否有标签、标签name、标签图片
        list.add(new DataBean("1", true, "张三李四", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("2", false, "张三李四", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("3", false, "张三李四", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("4", true, "C", com.macsags.suctiontop.R.drawable.ic_launcher_round));
        list.add(new DataBean("5", false, "C", com.macsags.suctiontop.R.drawable.ic_launcher_round));
        list.add(new DataBean("6", false, "C", com.macsags.suctiontop.R.drawable.ic_launcher_round));
        list.add(new DataBean("7", false, "C", com.macsags.suctiontop.R.drawable.ic_launcher_round));
        list.add(new DataBean("8", false, "C", com.macsags.suctiontop.R.drawable.ic_launcher_round));
        list.add(new DataBean("9", false, "C", com.macsags.suctiontop.R.drawable.ic_launcher_round));
        list.add(new DataBean("10", false, "C", com.macsags.suctiontop.R.drawable.ic_launcher_round));
        list.add(new DataBean("11", true, "J", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("12", false, "J", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("13", false, "J", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("14", false, "J", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("15", false, "J", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("16", true, "K", com.macsags.suctiontop.R.drawable.ic_launcher_round));
        list.add(new DataBean("17", false, "K", com.macsags.suctiontop.R.drawable.ic_launcher_round));
        list.add(new DataBean("18", false, "K", com.macsags.suctiontop.R.drawable.ic_launcher_round));
        list.add(new DataBean("19", true, "Y", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("20", false, "Y", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("21", false, "Y", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("22", false, "Y", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("23", false, "Y", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("24", true, "Z", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("25", false, "Z", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("26", false, "Z", com.macsags.suctiontop.R.drawable.ic_launcher));
        list.add(new DataBean("27", false, "Z", com.macsags.suctiontop.R.drawable.ic_launcher));
        return list;
    }

```
****
请关注
-------
  [我的博客](https://blog.csdn.net/qq_32368129)
  
