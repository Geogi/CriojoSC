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

package fr.emn.criojosc.model
package relation

import atom._
import pattern._

class TypedRelation2[T1, T2] extends RelationSymbol {
  def apply(v1: T1, v2: T2): ClosedAtom = new ClosedAtom(this, (v1, v2))
  def ?(p1: Pattern[T1], p2: Pattern[T2]): OpenAtom = new OpenAtom(this, new Tuple2Pattern((p1, p2)))
}

class TypedRelation3[T1, T2, T3] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3): ClosedAtom = new ClosedAtom(this, (v1, v2, v3))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3]): OpenAtom = new OpenAtom(this, new Tuple3Pattern((p1, p2, p3)))
}

class TypedRelation4[T1, T2, T3, T4] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4]): OpenAtom = new OpenAtom(this, new Tuple4Pattern((p1, p2, p3, p4)))
}

class TypedRelation5[T1, T2, T3, T4, T5] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5]): OpenAtom = new OpenAtom(this, new Tuple5Pattern((p1, p2, p3, p4, p5)))
}

class TypedRelation6[T1, T2, T3, T4, T5, T6] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6]): OpenAtom = new OpenAtom(this, new Tuple6Pattern((p1, p2, p3, p4, p5, p6)))
}

class TypedRelation7[T1, T2, T3, T4, T5, T6, T7] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7]): OpenAtom = new OpenAtom(this, new Tuple7Pattern((p1, p2, p3, p4, p5, p6, p7)))
}

class TypedRelation8[T1, T2, T3, T4, T5, T6, T7, T8] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8]): OpenAtom = new OpenAtom(this, new Tuple8Pattern((p1, p2, p3, p4, p5, p6, p7, p8)))
}

class TypedRelation9[T1, T2, T3, T4, T5, T6, T7, T8, T9] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9]): OpenAtom = new OpenAtom(this, new Tuple9Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9)))
}

class TypedRelation10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10]): OpenAtom = new OpenAtom(this, new Tuple10Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10)))
}

class TypedRelation11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11]): OpenAtom = new OpenAtom(this, new Tuple11Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)))
}

class TypedRelation12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12]): OpenAtom = new OpenAtom(this, new Tuple12Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12)))
}

class TypedRelation13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13]): OpenAtom = new OpenAtom(this, new Tuple13Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13)))
}

class TypedRelation14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14]): OpenAtom = new OpenAtom(this, new Tuple14Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14)))
}

class TypedRelation15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15]): OpenAtom = new OpenAtom(this, new Tuple15Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15)))
}

class TypedRelation16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15], p16: Pattern[T16]): OpenAtom = new OpenAtom(this, new Tuple16Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16)))
}

class TypedRelation17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15], p16: Pattern[T16], p17: Pattern[T17]): OpenAtom = new OpenAtom(this, new Tuple17Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17)))
}

class TypedRelation18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15], p16: Pattern[T16], p17: Pattern[T17], p18: Pattern[T18]): OpenAtom = new OpenAtom(this, new Tuple18Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18)))
}

class TypedRelation19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15], p16: Pattern[T16], p17: Pattern[T17], p18: Pattern[T18], p19: Pattern[T19]): OpenAtom = new OpenAtom(this, new Tuple19Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19)))
}

class TypedRelation20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19, v20: T20): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15], p16: Pattern[T16], p17: Pattern[T17], p18: Pattern[T18], p19: Pattern[T19], p20: Pattern[T20]): OpenAtom = new OpenAtom(this, new Tuple20Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20)))
}

class TypedRelation21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19, v20: T20, v21: T21): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15], p16: Pattern[T16], p17: Pattern[T17], p18: Pattern[T18], p19: Pattern[T19], p20: Pattern[T20], p21: Pattern[T21]): OpenAtom = new OpenAtom(this, new Tuple21Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21)))
}

class TypedRelation22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22] extends RelationSymbol {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19, v20: T20, v21: T21, v22: T22): ClosedAtom = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22))
  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15], p16: Pattern[T16], p17: Pattern[T17], p18: Pattern[T18], p19: Pattern[T19], p20: Pattern[T20], p21: Pattern[T21], p22: Pattern[T22]): OpenAtom = new OpenAtom(this, new Tuple22Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22)))
}

