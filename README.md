<h1 align="center">ToastOX <a href="https://github.com/10uroi/ToastOX#how-to-include"><img src="https://jitpack.io/v/10uroi/ToastOX.svg"></a></h1>
<h4 align="center">Android Library</h4>

<p align="center">
  <a target="_blank" href="https://android-arsenal.com/api?level=14"><img src="https://img.shields.io/badge/API-14%2B-orange.svg"></a>
</p>

<p align="center">A much nicer toast structure and a customized sub-dialog.</p>

<table align="center">
    <tr>
        <td>
            <img src="https://raw.githubusercontent.com/10uroi/ToastOX/master/Screenshots/1.jpg" height="400" />
        </td>
         <td>
            <img src="https://raw.githubusercontent.com/10uroi/ToastOX/master/Screenshots/9.jpg" height="400" />
        </td>
        <td>
            <img src="https://raw.githubusercontent.com/10uroi/ToastOX/master/Screenshots/8.jpg" height="400" />
        </td>
    </tr>
</table>


# How to include
Add the repository to your project **build.gradle**:

```Javascript
repositories {
	maven {
		url "https://jitpack.io"
	}
}
```

And add the library to your module **build.gradle**:

```Javascript
dependencies {
	compile 'com.github.10uroi:ToastOX:1.0.1'
}
```
# Usage
### ToastOX
    ToastOX.ok(getApplicationContext(), "Hello World! - OK");
    ToastOX.error(getApplicationContext(), "Hello World! - Error");
    ToastOX.info(getApplicationContext(), "Hello World! - Info");
    ToastOX.warning(getApplicationContext(), "Hello World! - Warning");
    ToastOX.muted(getApplicationContext(), "Hello World! - Muted");
    ToastOX.Tnull(getApplicationContext(), "Hello World! - Null");
    ToastOX.ok(getApplicationContext(), "Hello World! - OK", Toast.LENGTH_SHORT, 20, 200, 200);
    ...

<table align="center">
    <tr>
        <td>
            <img src="https://raw.githubusercontent.com/10uroi/ToastOX/master/Screenshots/2.jpg" />
        </td>
        <td>
            <img src="https://raw.githubusercontent.com/10uroi/ToastOX/master/Screenshots/3.jpg" />
        </td>
        <td>
            <img src="https://raw.githubusercontent.com/10uroi/ToastOX/master/Screenshots/4.jpg" />
        </td>
    </tr>
    </table>
    <table align="center">
    <tr>
        <td>
            <img src="https://raw.githubusercontent.com/10uroi/ToastOX/master/Screenshots/5.jpg" />
        </td>
        <td>
            <img src="https://raw.githubusercontent.com/10uroi/ToastOX/master/Screenshots/6.jpg" />
        </td>
        <td>
            <img src="https://raw.githubusercontent.com/10uroi/ToastOX/master/Screenshots/7.jpg" />
        </td>
    </tr>
</table>
<hr><hr>
### ToastOXDialog
```Javascript
      new ToastOXDialog.Build(this)
            .setTitle("Your Title")
            .setContent("You can write your message")
            .setPositiveText("Yes")
            .setPositiveBackgroundColorResource(R.color.orange)
            .setPositiveTextColorResource(R.color.black)
            .onPositive(new ToastOXDialog.ButtonCallback() {
                @Override
                public void onClick(@NonNull ToastOXDialog toastOXDialog) {
                    Log.i("Click","Yes");
                }
            })
            .setNegativeText("No")
            .setNegativeBackgroundColorResource(R.color.black)
            .setNegativeTextColorResource(R.color.orange)
            .onNegative(new ToastOXDialog.ButtonCallback(){
                @Override
                public void onClick(@NonNull ToastOXDialog toastOXDialog) {
                    Log.w("Click","No");
                }
            }).show();
```
<table align="center">
    <tr>
        <td>
            <img src="https://raw.githubusercontent.com/10uroi/ToastOX/master/Screenshots/9.jpg" height="400" />
        </td> 
        <td>
            <img src="https://raw.githubusercontent.com/10uroi/ToastOX/master/Screenshots/8.jpg" height="400" />
        </td>
    </tr>
</table>
