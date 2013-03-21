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

trait Relation extends EntitySymbol

object Relation {
  def apply[T1] = new TypedRelation[T1]

  def apply[T1, T2] = new TypedRelation2[T1, T2]

  def apply[T1, T2, T3] = new TypedRelation3[T1, T2, T3]

  def apply[T1, T2, T3, T4] = new TypedRelation4[T1, T2, T3, T4]

  def apply[T1, T2, T3, T4, T5] = new TypedRelation5[T1, T2, T3, T4, T5]

  def apply[T1, T2, T3, T4, T5, T6] = new TypedRelation6[T1, T2, T3, T4, T5, T6]

  def apply[T1, T2, T3, T4, T5, T6, T7] = new TypedRelation7[T1, T2, T3, T4, T5, T6, T7]

  def apply[T1, T2, T3, T4, T5, T6, T7, T8] = new TypedRelation8[T1, T2, T3, T4, T5, T6, T7, T8]

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9] = new TypedRelation9[T1, T2, T3, T4, T5, T6, T7, T8, T9]

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10] = new TypedRelation10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11] = new TypedRelation11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12] = new TypedRelation12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13] = new TypedRelation13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14] = new TypedRelation14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15] = new TypedRelation15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16] = new TypedRelation16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17] = new TypedRelation17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18] = new TypedRelation18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19] = new TypedRelation19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20] = new TypedRelation20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21] = new TypedRelation21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22] = new TypedRelation22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]
}

class TypedRelation2[T1, T2] extends Relation {
  def apply(v1: T1, v2: T2) = new ClosedAtom(this, (v1, v2))

  def ?(p1: Pattern[T1], p2: Pattern[T2]) = new OpenAtom(this, new Tuple2Pattern((p1, p2)))
}

class TypedRelation3[T1, T2, T3] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3) = new ClosedAtom(this, (v1, v2, v3))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3]) = new OpenAtom(this, new Tuple3Pattern((p1, p2, p3)))
}

class TypedRelation4[T1, T2, T3, T4] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4) = new ClosedAtom(this, (v1, v2, v3, v4))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4]) = new OpenAtom(this, new Tuple4Pattern((p1, p2, p3, p4)))
}

class TypedRelation5[T1, T2, T3, T4, T5] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5) = new ClosedAtom(this, (v1, v2, v3, v4, v5))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5]) = new OpenAtom(this, new Tuple5Pattern((p1, p2, p3, p4, p5)))
}

class TypedRelation6[T1, T2, T3, T4, T5, T6] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6]) = new OpenAtom(this, new Tuple6Pattern((p1, p2, p3, p4, p5, p6)))
}

class TypedRelation7[T1, T2, T3, T4, T5, T6, T7] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7]) = new OpenAtom(this, new Tuple7Pattern((p1, p2, p3, p4, p5, p6, p7)))
}

class TypedRelation8[T1, T2, T3, T4, T5, T6, T7, T8] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8]) = new OpenAtom(this, new Tuple8Pattern((p1, p2, p3, p4, p5, p6, p7, p8)))
}

class TypedRelation9[T1, T2, T3, T4, T5, T6, T7, T8, T9] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9]) = new OpenAtom(this, new Tuple9Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9)))
}

class TypedRelation10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10]) = new OpenAtom(this, new Tuple10Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10)))
}

class TypedRelation11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11]) = new OpenAtom(this, new Tuple11Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)))
}

class TypedRelation12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12]) = new OpenAtom(this, new Tuple12Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12)))
}

class TypedRelation13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13]) = new OpenAtom(this, new Tuple13Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13)))
}

class TypedRelation14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14]) = new OpenAtom(this, new Tuple14Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14)))
}

class TypedRelation15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15]) = new OpenAtom(this, new Tuple15Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15)))
}

class TypedRelation16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15], p16: Pattern[T16]) = new OpenAtom(this, new Tuple16Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16)))
}

class TypedRelation17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15], p16: Pattern[T16], p17: Pattern[T17]) = new OpenAtom(this, new Tuple17Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17)))
}

class TypedRelation18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15], p16: Pattern[T16], p17: Pattern[T17], p18: Pattern[T18]) = new OpenAtom(this, new Tuple18Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18)))
}

class TypedRelation19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15], p16: Pattern[T16], p17: Pattern[T17], p18: Pattern[T18], p19: Pattern[T19]) = new OpenAtom(this, new Tuple19Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19)))
}

class TypedRelation20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19, v20: T20) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15], p16: Pattern[T16], p17: Pattern[T17], p18: Pattern[T18], p19: Pattern[T19], p20: Pattern[T20]) = new OpenAtom(this, new Tuple20Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20)))
}

class TypedRelation21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19, v20: T20, v21: T21) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15], p16: Pattern[T16], p17: Pattern[T17], p18: Pattern[T18], p19: Pattern[T19], p20: Pattern[T20], p21: Pattern[T21]) = new OpenAtom(this, new Tuple21Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21)))
}

class TypedRelation22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22] extends Relation {
  def apply(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19, v20: T20, v21: T21, v22: T22) = new ClosedAtom(this, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22))

  def ?(p1: Pattern[T1], p2: Pattern[T2], p3: Pattern[T3], p4: Pattern[T4], p5: Pattern[T5], p6: Pattern[T6], p7: Pattern[T7], p8: Pattern[T8], p9: Pattern[T9], p10: Pattern[T10], p11: Pattern[T11], p12: Pattern[T12], p13: Pattern[T13], p14: Pattern[T14], p15: Pattern[T15], p16: Pattern[T16], p17: Pattern[T17], p18: Pattern[T18], p19: Pattern[T19], p20: Pattern[T20], p21: Pattern[T21], p22: Pattern[T22]) = new OpenAtom(this, new Tuple22Pattern((p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22)))
}

