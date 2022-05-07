# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.dreamers.observablefield.ObservableField {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/dreamers/observablefield/repack'
-flattenpackagehierarchy
-dontpreverify
