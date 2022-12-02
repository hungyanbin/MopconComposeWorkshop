# MopconComposeWorkshop

![Screen Shot 2022-12-02 at 9 25 31 PM](https://user-images.githubusercontent.com/7949400/205302823-3d72368d-d2fa-4a27-94aa-671ec7ccdba8.png)

## 專案介紹
本專案為 Android Taipei Jetpack Compose workshop 的上課範例，本專案包含了：
1. 各種使用 Canvas API 的範例程式碼，位於 com.android.taipei.sample 裡
2. 折線圖各階段程式碼，位於 com.android.taipei.steps 裡
3. 折線圖最後成果程式碼，位於 com.android.taipei.answer 裡

投影片連結： https://docs.google.com/presentation/d/1DV_VWNqnJcF9Nku-zvZZdeLcquzsPdysnh452FxRGqU/edit?usp=sharing

## 疑難雜症排解
1. 專案無法建置：試著將 `settings.gradle` 中第五行 `mavenCentral()` 與第三行的 `gradlePluginPortal()` 做交換，再點擊 "build -> make project"


