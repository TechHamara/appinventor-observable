package com.dreamers.observablefield

import com.google.appinventor.components.annotations.SimpleEvent
import com.google.appinventor.components.annotations.SimpleProperty
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent
import com.google.appinventor.components.runtime.ComponentContainer
import com.google.appinventor.components.runtime.EventDispatcher
import kotlin.properties.Delegates

@Suppress("FunctionName")
class ObservableField(container: ComponentContainer) : AndroidNonvisibleComponent(container.`$form`()) {

    private var observable by Delegates.observable<Any?>(null) { _, oldValue, newValue ->
        OnChange(oldValue, newValue)
    }

    @SimpleProperty(
        description = "Update value of observable."
    )
    fun Value(value: Any?) {
        observable = value
    }

    @SimpleProperty(
        description = "Get value of observable. Returns null if no value is set."
    )
    fun Value(): Any? {
        return observable
    }

    @SimpleEvent(
        description = "The event which is called after the change of the property is made. The value of the property has already been changed when this event is invoked."
    )
    fun OnChange(oldValue: Any?, newValue: Any?) {
        EventDispatcher.dispatchEvent(this, "OnChange", oldValue, newValue)
    }

}
