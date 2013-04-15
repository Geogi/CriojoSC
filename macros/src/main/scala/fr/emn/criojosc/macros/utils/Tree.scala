/*
 * Copyright (c) 2013 Mines Nantes.
 *
 * This file is part of CriojoSC.
 *
 * CriojoSC is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CriojoSC is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CriojoSC.  If not, see <http://www.gnu.org/licenses/>.
 */

package fr.emn.criojosc.macros.utils

import scala.collection.immutable.ListMap

trait Tree

//extracted from scala/reflect/api/* (matching .*Extractor)
case class Annotation(tpe: Type, scalaArgs: List[Tree], javaArgs: ListMap[String, JavaArgument]) extends Tree
case class LiteralArgument(value: Constant) extends Tree
case class ArrayArgument(args: Array[JavaArgument]) extends Tree
case class NestedArgument(annotation: Annotation) extends Tree
case class Constant(value: Any) extends Tree
case class PackageDef(pid: RefTree, stats: List[Tree]) extends Tree
case class ClassDef(mods: Modifiers, name: String, tparams: List[TypeDef], impl: Template) extends Tree
case class ModuleDef(mods: Modifiers, name: String, impl: Template) extends Tree
case class ValDef(mods: Modifiers, name: String, tpt: Tree, rhs: Tree) extends Tree
case class DefDef(mods: Modifiers, name: String, tparams: List[TypeDef], vparamss: List[List[ValDef]], tpt: Tree, rhs: Tree) extends Tree
case class TypeDef(mods: Modifiers, name: String, tparams: List[TypeDef], rhs: Tree) extends Tree
case class LabelDef(name: String, params: List[Ident], rhs: Tree) extends Tree
case class ImportSelector(name: String, namePos: Int, rename: String, renamePos: Int) extends Tree
case class Import(expr: Tree, selectors: List[ImportSelector]) extends Tree
case class Template(parents: List[Tree], self: ValDef, body: List[Tree]) extends Tree
case class Block(stats: List[Tree], expr: Tree) extends Tree
case class CaseDef(pat: Tree, guard: Tree, body: Tree) extends Tree
case class Alternative(trees: List[Tree]) extends Tree
case class Star(elem: Tree) extends Tree
case class Bind(name: String, body: Tree) extends Tree
case class UnApply(fun: Tree, args: List[Tree]) extends Tree
case class Function(vparams: List[ValDef], body: Tree) extends Tree
case class Assign(lhs: Tree, rhs: Tree) extends Tree
case class AssignOrNamedArg(lhs: Tree, rhs: Tree) extends Tree
case class If(cond: Tree, thenp: Tree, elsep: Tree) extends Tree
case class Match(selector: Tree, cases: List[CaseDef]) extends Tree
case class Return(expr: Tree) extends Tree
case class Try(block: Tree, catches: List[CaseDef], finalizer: Tree) extends Tree
case class Throw(expr: Tree) extends Tree
case class New(tpt: Tree) extends Tree
case class Typed(expr: Tree, tpt: Tree) extends Tree
case class TypeApply(fun: Tree, args: List[Tree]) extends Tree
case class Apply(fun: Tree, args: List[Tree]) extends Tree
case class Super(qual: Tree, mix: String) extends Tree
case class This(qual: String) extends Tree
case class Select(qualifier: Tree, name: String) extends Tree
case class Ident(name: String) extends Tree
case class ReferenceToBoxed(ident: Ident) extends Tree
case class Literal(value: Constant) extends Tree
case class Annotated(annot: Tree, arg: Tree) extends Tree
case class SingletonTypeTree(ref: Tree) extends Tree
case class SelectFromTypeTree(qualifier: Tree, name: String) extends Tree
case class CompoundTypeTree(templ: Template) extends Tree
case class AppliedTypeTree(tpt: Tree, args: List[Tree]) extends Tree
case class TypeBoundsTree(lo: Tree, hi: Tree) extends Tree
case class ExistentialTypeTree(tpt: Tree, whereClauses: List[Tree]) extends Tree
case class TypeTree() extends Tree
case class ThisType(sym: Symbol) extends Tree
case class SingleType(pre: Type, sym: Symbol) extends Tree
case class SuperType(thistpe: Type, supertpe: Type) extends Tree
case class ConstantType(value: Constant) extends Tree
case class TypeRef(pre: Type, sym: Symbol, args: List[Type]) extends Tree
case class RefinedType(parents: List[Type], decls: Scope) extends Tree
case class ClassInfoType(parents: List[Type], decls: Scope, typeSymbol: Symbol) extends Tree
case class MethodType(params: List[Symbol], resultType: Type) extends Tree
case class NullaryMethodType(resultType: Type) extends Tree
case class PolyType(typeParams: List[Symbol], resultType: Type) extends Tree
case class ExistentialType(quantified: List[Symbol], underlying: Type) extends Tree
case class AnnotatedType(annotations: List[Annotation], underlying: Type, selfsym: Symbol) extends Tree
case class TypeBounds(lo: Type, hi: Type) extends Tree
case class BoundedWildcardType(bounds: TypeBounds) extends Tree

//dummy traits
trait JavaArgument
trait RefTree
trait Modifiers
trait Type
trait Scope