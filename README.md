## Android-MVP

안드로이드 MVP 모델을 공부하면서 정리한 README 입니다.



## MVP Model ??



MVP Model이란, 안드로이드 패턴중에 하나입니다. Model, Presenter, View 간의 상호 의존성을 떨어트리기 위한 용도로 사용됩니다.

</br>

**View** - 이벤트가 발생하고, 이를 Presenter로 넘겨 처리 하도록 한다.

**Model** - Data와 관련된 처리를 당담한다.

**Presenter** - View에서 전달받은 이벤트를 처리하고, 다시 View로 전달한다.

</br>

![Mvp-Pattern](https://github.com/Im-Tae/Android-MVP-Example/blob/master/Image/mvp-pattern.png?raw=true)

</br>

Mvp 패턴의 동작을 나열하면,



**View** - View에서 이벤트 발생

**View -> Presenter** - Presenter로 이벤트 전달

**Presenter** - 이벤트 형태에 따라 캐시 데이터를 가져오거나 Model에 데이터 요청

**Presenter -> Model** - Presenter에서 데이터 요청을 받음

**Model** - 데이터를 로컬, 서버에서 가져옴

**Model -> Presenter** - Model에서 데이터를 받음

**Presenter** - 데이터를 가공

**Presenter -> View** - 가공된 데이터를 View에 전달

**View** - 데이터를 View에 갱신


</br>

## Presenter를 구현하는 방법



Presenter를 구현하는 방법으로는 아래와 같습니다.

</br>


View에 대한 interface만 정의하는 방법 ( interface View, Presenter, View )

Google architecture를 따르는 방법 ( Contract, Presenter, View )

PresenterImpl을 구현하는 방법 ( Presenter, PresenterImpl, View )


</br>

3가지로 나뉠 수 있고, 편한 방법으로 작성하시면 됩니다.



interface를 정의 하는 이유는 코드를 처음 보는 사람이 코드 파악을 쉽게 하도록 하기 위함입니다.





</br>

아래 예제는 Google architecture MVP 모델을 이용하여 만들어본 Toast 메세지를 보여주는 간단한 예제입니다.

```kotlin
// MainContact.kt

interface MainContract {
    interface View {

        val presenter: Presenter

        fun showToast()
    }

    interface Presenter {

        val view: View

        fun clickButton()
    }
}
```



```kotlin
// MainActivity.kt

class MainActivity : AppCompatActivity(), MainContract.View {

    override lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
    }

    override fun showToast() = Toast.makeText(this, "버튼을 클릭했습니다.", Toast.LENGTH_SHORT).show()
}
```



```kotlin
// MainPresenter.kt

class MainPresenter(override val view: MainContract.View): MainContract.Presenter {

    override fun clickButton() = view.showToast()

}
```