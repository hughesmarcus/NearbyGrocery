package com.product.marcus.nearbygrocery.ui.groceryList.additem

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.product.marcus.nearbygrocery.ui.BaseActivity
import com.product.marcus.nearbygrocery.R
import com.product.marcus.nearbygrocery.database.Item
import android.text.SpannableStringBuilder
import com.product.marcus.nearbygrocery.ui.groceryList.list.di.DaggerEditItemComponent
import com.product.marcus.nearbygrocery.application.AppController
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_edit_item.*


class EditItemActivity : BaseActivity(), EditItemView {
    @Inject lateinit var presenter: EditItemPresenter
    lateinit var item: Item
    var new: Boolean = false
    var minteger = 0
    private lateinit var displayInteger: EditText

    companion object {
        private val IT = "item"
        fun launch(context: Context, item: Item) {
            val intent = Intent(context, EditItemActivity::class.java)
            intent.putExtra(IT, item)
            context.startActivity(intent)
        }

        fun launch(context: Context) {
            val intent = Intent(context, EditItemActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_item)

        intNav()
        displayInteger = findViewById(
                R.id.amount)
        DaggerEditItemComponent.builder().
                appComponent(AppController.appComponent).
                editItemContextModule(EditItemContextModule(this)).
                build().inject(this)
        if (intent.hasExtra(IT)) {
            item = intent.getParcelableExtra(IT)
            new = false
        } else {
            new = true
            item = Item()
        }


        minteger = item.quantity
        intVal()
        intButtons()
        presenter.view = this

    }

    private fun intButtons() {
        if (intent.hasExtra(IT)) {
            save.setOnClickListener {
                item.name = item_name.text.toString()
                item.category = category.text.toString()
                item.notes = notes.text.toString()
                item.price = price.text.toString().toDouble()
                item.quantity = amount.text.toString().toInt()
                item.store = ""
                item.unit = units.text.toString()
                presenter.updateItem(item)
                finish()
            }
        } else {
            save.setOnClickListener {
                item.name = item_name.text.toString()
                item.category = category.text.toString()
                item.notes = notes.text.toString()
                item.price = price.text.toString().toDouble()
                item.quantity = amount.text.toString().toInt()
                item.store = ""
                item.unit = units.text.toString()
                item.checked = false
                presenter.addItem(item)
                finish()
            }
        }

        delete.setOnClickListener {
            presenter.deleteItem(item)
            finish()
        }
    }

    private fun intVal() {

        val editable = SpannableStringBuilder("" + item.quantity)
        displayInteger.text = editable
        item_name.text = SpannableStringBuilder(item.name)
        units.text = SpannableStringBuilder(item.unit)
        price.text = SpannableStringBuilder("" + item.price)
        category.text = SpannableStringBuilder(item.category)
        notes.text = SpannableStringBuilder(item.notes)




    }

    fun increaseInteger(view: View) {
        minteger += 1
        display(minteger)

    }

    fun decreaseInteger(view: View) {
        minteger -= 1
        display(minteger)
    }

    private fun display(number: Int) {
        val editable = SpannableStringBuilder("" + number)
        displayInteger.text = editable
    }

    override fun onDestroy() {
        presenter.compositeDisposable.dispose()
        presenter.view = null
        super.onDestroy()
    }

    override fun onFailure(appErrorMessage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
