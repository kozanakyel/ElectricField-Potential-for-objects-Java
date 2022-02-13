# Java-Physics
This application shows how to particles waves changing and how to calculate magnitude field with 3d projectory.


Firstly we mention about ElectricApp. This app shows hotw to a charge Conducting or 
Insulting Sphere has a Elecvtric Potential Vlaue and Electic Field Vector magnitude. 
Also how to Calculate each of them with using JAva so instantly how to show 
an 3D representation for them.

I created IElectric Java interface because i think all of the object has 
an electrical behaviour for our app. This interface has 2 method eFieldVectorMagnitude and 
potentialAt(). then each object extends MyPoint Abstract object because every material 
composed of some point configuration like as atomic particle united.

I* calculated Potential value for eaach coordinate point and many object or charge that is not problem for us.
potential = (Columb*myObject.getQ())/distance(x, y). another problem for us this object angle and electric field angle. Maybe
potential and vector field computation just adding operation we know for x and y vector that we have them.
