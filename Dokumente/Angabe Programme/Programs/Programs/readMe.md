# Readme
**TODO: Question whether modification restrictions for predicate-level annotations are necessary? Probably better to focus on restrictions for predicates, rules, and facts.**

## Programs
Each program is written in such a way that it can be executed indepenently of other programs. The specific inputs and outputs are noted in the respective programs. Test cases for each program are given in the corresponding Jupyter notebooks.

## Inheritance
We employ Vadalog, a Datalog+- implementation. Vadalog uses annotations to mark for instance input predicates. Since one can define user-annotations we utilize annotations to realize our approach.

Supported is multi-inheritance with modification restrictions in Vadalog as far as possible in the current VAdalog version (e.g. Annotations cannot be labelled yet, thus for instance input predicates cannot be removed).

`@module(<name>)` specifies a rule modules name, `@inherits(<parent>)` can be used to specify a parent module.
We support modification operations `@remove` and `@redefine`.
Regarding restrictions we support
* `@no_additional_input`
* `@no_additional_output`
* `@no_additional_annotation` e.g. an additional bind for a specific predicate is not allowed
* `@non_omitable_annotation` e.g. removing a defined bind for a predicate is not allowed
* `@non_omitable`
* `@non_redefinable`
* `@non_growable`
* `@non_shrinkable`

*Not supported yet is redefinition of predicate annotations (e.g. binds)!!*

The first part contains inheritance resolving and output to predicate `line`. The second part reports potential problems in the inheritance hierarchy.

## Abstraction
This program determines whether a given resolved module (in meta-form) is abstract and which predicates are abstract.

## Structural Detection
Determines for a set of modules forming an inheritance tree (in meta-form) the performed modifications operations in the different modules.
A second variant of this program based on resolved modules and their inheritance relations. It needs less lines of code but cannot detect redefinitions.

## Behavioral Detection
We support dynamic and static detection. Dynamic detection uses resultsets whereas static detection uses meta-representations of the rule module hierarchy.

## Conformance
Once modification operations are detected, this program can be used to compare them with the defined modification restrictions. Any violations are reported.
