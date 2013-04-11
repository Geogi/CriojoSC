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

package fr.emn.criojosc

import reflect.macros.Context

object RelationMacros {
  def genClosedAtom(c: Context)(v: c.Expr[Any])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    reify(new ClosedAtom(symbol.splice, v.splice, c.Expr[String](Literal(Constant(show(v)))).splice))
  }
  def genClosedAtom2[T1: c.WeakTypeTag, T2: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice)))(symbol)
  }
  def genClosedAtom3[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice)))(symbol)
  }
  def genClosedAtom4[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice)))(symbol)
  }
  def genClosedAtom5[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice)))(symbol)
  }
  def genClosedAtom6[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice)))(symbol)
  }
  def genClosedAtom7[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice)))(symbol)
  }
  def genClosedAtom8[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag, T8: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7], v8: c.Expr[T8])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice, v8.splice)))(symbol)
  }
  def genClosedAtom9[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag, T8: c.WeakTypeTag, T9: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7], v8: c.Expr[T8], v9: c.Expr[T9])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice, v8.splice, v9.splice)))(symbol)
  }
  def genClosedAtom10[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag, T8: c.WeakTypeTag, T9: c.WeakTypeTag, T10: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7], v8: c.Expr[T8], v9: c.Expr[T9], v10: c.Expr[T10])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice, v8.splice, v9.splice, v10.splice)))(symbol)
  }
  def genClosedAtom11[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag, T8: c.WeakTypeTag, T9: c.WeakTypeTag, T10: c.WeakTypeTag, T11: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7], v8: c.Expr[T8], v9: c.Expr[T9], v10: c.Expr[T10], v11: c.Expr[T11])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice, v8.splice, v9.splice, v10.splice, v11.splice)))(symbol)
  }
  def genClosedAtom12[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag, T8: c.WeakTypeTag, T9: c.WeakTypeTag, T10: c.WeakTypeTag, T11: c.WeakTypeTag, T12: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7], v8: c.Expr[T8], v9: c.Expr[T9], v10: c.Expr[T10], v11: c.Expr[T11], v12: c.Expr[T12])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice, v8.splice, v9.splice, v10.splice, v11.splice, v12.splice)))(symbol)
  }
  def genClosedAtom13[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag, T8: c.WeakTypeTag, T9: c.WeakTypeTag, T10: c.WeakTypeTag, T11: c.WeakTypeTag, T12: c.WeakTypeTag, T13: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7], v8: c.Expr[T8], v9: c.Expr[T9], v10: c.Expr[T10], v11: c.Expr[T11], v12: c.Expr[T12], v13: c.Expr[T13])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice, v8.splice, v9.splice, v10.splice, v11.splice, v12.splice, v13.splice)))(symbol)
  }
  def genClosedAtom14[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag, T8: c.WeakTypeTag, T9: c.WeakTypeTag, T10: c.WeakTypeTag, T11: c.WeakTypeTag, T12: c.WeakTypeTag, T13: c.WeakTypeTag, T14: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7], v8: c.Expr[T8], v9: c.Expr[T9], v10: c.Expr[T10], v11: c.Expr[T11], v12: c.Expr[T12], v13: c.Expr[T13], v14: c.Expr[T14])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice, v8.splice, v9.splice, v10.splice, v11.splice, v12.splice, v13.splice, v14.splice)))(symbol)
  }
  def genClosedAtom15[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag, T8: c.WeakTypeTag, T9: c.WeakTypeTag, T10: c.WeakTypeTag, T11: c.WeakTypeTag, T12: c.WeakTypeTag, T13: c.WeakTypeTag, T14: c.WeakTypeTag, T15: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7], v8: c.Expr[T8], v9: c.Expr[T9], v10: c.Expr[T10], v11: c.Expr[T11], v12: c.Expr[T12], v13: c.Expr[T13], v14: c.Expr[T14], v15: c.Expr[T15])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice, v8.splice, v9.splice, v10.splice, v11.splice, v12.splice, v13.splice, v14.splice, v15.splice)))(symbol)
  }
  def genClosedAtom16[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag, T8: c.WeakTypeTag, T9: c.WeakTypeTag, T10: c.WeakTypeTag, T11: c.WeakTypeTag, T12: c.WeakTypeTag, T13: c.WeakTypeTag, T14: c.WeakTypeTag, T15: c.WeakTypeTag, T16: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7], v8: c.Expr[T8], v9: c.Expr[T9], v10: c.Expr[T10], v11: c.Expr[T11], v12: c.Expr[T12], v13: c.Expr[T13], v14: c.Expr[T14], v15: c.Expr[T15], v16: c.Expr[T16])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice, v8.splice, v9.splice, v10.splice, v11.splice, v12.splice, v13.splice, v14.splice, v15.splice, v16.splice)))(symbol)
  }
  def genClosedAtom17[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag, T8: c.WeakTypeTag, T9: c.WeakTypeTag, T10: c.WeakTypeTag, T11: c.WeakTypeTag, T12: c.WeakTypeTag, T13: c.WeakTypeTag, T14: c.WeakTypeTag, T15: c.WeakTypeTag, T16: c.WeakTypeTag, T17: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7], v8: c.Expr[T8], v9: c.Expr[T9], v10: c.Expr[T10], v11: c.Expr[T11], v12: c.Expr[T12], v13: c.Expr[T13], v14: c.Expr[T14], v15: c.Expr[T15], v16: c.Expr[T16], v17: c.Expr[T17])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice, v8.splice, v9.splice, v10.splice, v11.splice, v12.splice, v13.splice, v14.splice, v15.splice, v16.splice, v17.splice)))(symbol)
  }
  def genClosedAtom18[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag, T8: c.WeakTypeTag, T9: c.WeakTypeTag, T10: c.WeakTypeTag, T11: c.WeakTypeTag, T12: c.WeakTypeTag, T13: c.WeakTypeTag, T14: c.WeakTypeTag, T15: c.WeakTypeTag, T16: c.WeakTypeTag, T17: c.WeakTypeTag, T18: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7], v8: c.Expr[T8], v9: c.Expr[T9], v10: c.Expr[T10], v11: c.Expr[T11], v12: c.Expr[T12], v13: c.Expr[T13], v14: c.Expr[T14], v15: c.Expr[T15], v16: c.Expr[T16], v17: c.Expr[T17], v18: c.Expr[T18])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice, v8.splice, v9.splice, v10.splice, v11.splice, v12.splice, v13.splice, v14.splice, v15.splice, v16.splice, v17.splice, v18.splice)))(symbol)
  }
  def genClosedAtom19[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag, T8: c.WeakTypeTag, T9: c.WeakTypeTag, T10: c.WeakTypeTag, T11: c.WeakTypeTag, T12: c.WeakTypeTag, T13: c.WeakTypeTag, T14: c.WeakTypeTag, T15: c.WeakTypeTag, T16: c.WeakTypeTag, T17: c.WeakTypeTag, T18: c.WeakTypeTag, T19: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7], v8: c.Expr[T8], v9: c.Expr[T9], v10: c.Expr[T10], v11: c.Expr[T11], v12: c.Expr[T12], v13: c.Expr[T13], v14: c.Expr[T14], v15: c.Expr[T15], v16: c.Expr[T16], v17: c.Expr[T17], v18: c.Expr[T18], v19: c.Expr[T19])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice, v8.splice, v9.splice, v10.splice, v11.splice, v12.splice, v13.splice, v14.splice, v15.splice, v16.splice, v17.splice, v18.splice, v19.splice)))(symbol)
  }
  def genClosedAtom20[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag, T8: c.WeakTypeTag, T9: c.WeakTypeTag, T10: c.WeakTypeTag, T11: c.WeakTypeTag, T12: c.WeakTypeTag, T13: c.WeakTypeTag, T14: c.WeakTypeTag, T15: c.WeakTypeTag, T16: c.WeakTypeTag, T17: c.WeakTypeTag, T18: c.WeakTypeTag, T19: c.WeakTypeTag, T20: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7], v8: c.Expr[T8], v9: c.Expr[T9], v10: c.Expr[T10], v11: c.Expr[T11], v12: c.Expr[T12], v13: c.Expr[T13], v14: c.Expr[T14], v15: c.Expr[T15], v16: c.Expr[T16], v17: c.Expr[T17], v18: c.Expr[T18], v19: c.Expr[T19], v20: c.Expr[T20])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice, v8.splice, v9.splice, v10.splice, v11.splice, v12.splice, v13.splice, v14.splice, v15.splice, v16.splice, v17.splice, v18.splice, v19.splice, v20.splice)))(symbol)
  }
  def genClosedAtom21[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag, T8: c.WeakTypeTag, T9: c.WeakTypeTag, T10: c.WeakTypeTag, T11: c.WeakTypeTag, T12: c.WeakTypeTag, T13: c.WeakTypeTag, T14: c.WeakTypeTag, T15: c.WeakTypeTag, T16: c.WeakTypeTag, T17: c.WeakTypeTag, T18: c.WeakTypeTag, T19: c.WeakTypeTag, T20: c.WeakTypeTag, T21: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7], v8: c.Expr[T8], v9: c.Expr[T9], v10: c.Expr[T10], v11: c.Expr[T11], v12: c.Expr[T12], v13: c.Expr[T13], v14: c.Expr[T14], v15: c.Expr[T15], v16: c.Expr[T16], v17: c.Expr[T17], v18: c.Expr[T18], v19: c.Expr[T19], v20: c.Expr[T20], v21: c.Expr[T21])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice, v8.splice, v9.splice, v10.splice, v11.splice, v12.splice, v13.splice, v14.splice, v15.splice, v16.splice, v17.splice, v18.splice, v19.splice, v20.splice, v21.splice)))(symbol)
  }
  def genClosedAtom22[T1: c.WeakTypeTag, T2: c.WeakTypeTag, T3: c.WeakTypeTag, T4: c.WeakTypeTag, T5: c.WeakTypeTag, T6: c.WeakTypeTag, T7: c.WeakTypeTag, T8: c.WeakTypeTag, T9: c.WeakTypeTag, T10: c.WeakTypeTag, T11: c.WeakTypeTag, T12: c.WeakTypeTag, T13: c.WeakTypeTag, T14: c.WeakTypeTag, T15: c.WeakTypeTag, T16: c.WeakTypeTag, T17: c.WeakTypeTag, T18: c.WeakTypeTag, T19: c.WeakTypeTag, T20: c.WeakTypeTag, T21: c.WeakTypeTag, T22: c.WeakTypeTag](c: Context)(v1: c.Expr[T1], v2: c.Expr[T2], v3: c.Expr[T3], v4: c.Expr[T4], v5: c.Expr[T5], v6: c.Expr[T6], v7: c.Expr[T7], v8: c.Expr[T8], v9: c.Expr[T9], v10: c.Expr[T10], v11: c.Expr[T11], v12: c.Expr[T12], v13: c.Expr[T13], v14: c.Expr[T14], v15: c.Expr[T15], v16: c.Expr[T16], v17: c.Expr[T17], v18: c.Expr[T18], v19: c.Expr[T19], v20: c.Expr[T20], v21: c.Expr[T21], v22: c.Expr[T22])(symbol: c.Expr[RelationSymbol]): c.Expr[ClosedAtom] = {
    import c.universe._
    genClosedAtom(c)(reify((v1.splice, v2.splice, v3.splice, v4.splice, v5.splice, v6.splice, v7.splice, v8.splice, v9.splice, v10.splice, v11.splice, v12.splice, v13.splice, v14.splice, v15.splice, v16.splice, v17.splice, v18.splice, v19.splice, v20.splice, v21.splice, v22.splice)))(symbol)
  }
}
