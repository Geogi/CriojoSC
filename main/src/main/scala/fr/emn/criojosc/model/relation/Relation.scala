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

package fr.emn.criojosc.model.relation

object Relation {
  def apply[T1] = new TypedRelation[T1]
  def apply[T1](s: String) = new TypedRelation[T1] {
    override val optName = Some(s)
  }
  def multi[T1](ss: String*) = ss.map(apply[T1](_))
  def apply[T1, T2] = new TypedRelation2[T1, T2]
  def apply[T1, T2](s: String) = new TypedRelation2[T1, T2] {
    override val optName = Some(s)
  }
  def multi2[T1, T2](ss: String*) = ss.map(apply[T1, T2](_))
  def apply[T1, T2, T3] = new TypedRelation3[T1, T2, T3]
  def apply[T1, T2, T3](s: String) = new TypedRelation3[T1, T2, T3] {
    override val optName = Some(s)
  }
  def multi3[T1, T2, T3](ss: String*) = ss.map(apply[T1, T2, T3](_))
  def apply[T1, T2, T3, T4] = new TypedRelation4[T1, T2, T3, T4]
  def apply[T1, T2, T3, T4](s: String) = new TypedRelation4[T1, T2, T3, T4] {
    override val optName = Some(s)
  }
  def multi4[T1, T2, T3, T4](ss: String*) = ss.map(apply[T1, T2, T3, T4](_))
  def apply[T1, T2, T3, T4, T5] = new TypedRelation5[T1, T2, T3, T4, T5]
  def apply[T1, T2, T3, T4, T5](s: String) = new TypedRelation5[T1, T2, T3, T4, T5] {
    override val optName = Some(s)
  }
  def multi5[T1, T2, T3, T4, T5](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5](_))
  def apply[T1, T2, T3, T4, T5, T6] = new TypedRelation6[T1, T2, T3, T4, T5, T6]
  def apply[T1, T2, T3, T4, T5, T6](s: String) = new TypedRelation6[T1, T2, T3, T4, T5, T6] {
    override val optName = Some(s)
  }
  def multi6[T1, T2, T3, T4, T5, T6](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6](_))
  def apply[T1, T2, T3, T4, T5, T6, T7] = new TypedRelation7[T1, T2, T3, T4, T5, T6, T7]
  def apply[T1, T2, T3, T4, T5, T6, T7](s: String) = new TypedRelation7[T1, T2, T3, T4, T5, T6, T7] {
    override val optName = Some(s)
  }
  def multi7[T1, T2, T3, T4, T5, T6, T7](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7](_))
  def apply[T1, T2, T3, T4, T5, T6, T7, T8] = new TypedRelation8[T1, T2, T3, T4, T5, T6, T7, T8]
  def apply[T1, T2, T3, T4, T5, T6, T7, T8](s: String) = new TypedRelation8[T1, T2, T3, T4, T5, T6, T7, T8] {
    override val optName = Some(s)
  }
  def multi8[T1, T2, T3, T4, T5, T6, T7, T8](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7, T8](_))
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9] = new TypedRelation9[T1, T2, T3, T4, T5, T6, T7, T8, T9]
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9](s: String) = new TypedRelation9[T1, T2, T3, T4, T5, T6, T7, T8, T9] {
    override val optName = Some(s)
  }
  def multi9[T1, T2, T3, T4, T5, T6, T7, T8, T9](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7, T8, T9](_))
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10] = new TypedRelation10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10](s: String) = new TypedRelation10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10] {
    override val optName = Some(s)
  }
  def multi10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10](_))
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11] = new TypedRelation11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11](s: String) = new TypedRelation11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11] {
    override val optName = Some(s)
  }
  def multi11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11](_))
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12] = new TypedRelation12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12](s: String) = new TypedRelation12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12] {
    override val optName = Some(s)
  }
  def multi12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12](_))
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13] = new TypedRelation13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13](s: String) = new TypedRelation13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13] {
    override val optName = Some(s)
  }
  def multi13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13](_))
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14] = new TypedRelation14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14](s: String) = new TypedRelation14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14] {
    override val optName = Some(s)
  }
  def multi14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14](_))
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15] = new TypedRelation15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15](s: String) = new TypedRelation15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15] {
    override val optName = Some(s)
  }
  def multi15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15](_))
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16] = new TypedRelation16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16](s: String) = new TypedRelation16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16] {
    override val optName = Some(s)
  }
  def multi16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16](_))
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17] = new TypedRelation17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17](s: String) = new TypedRelation17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17] {
    override val optName = Some(s)
  }
  def multi17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17](_))
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18] = new TypedRelation18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18](s: String) = new TypedRelation18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18] {
    override val optName = Some(s)
  }
  def multi18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18](_))
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19] = new TypedRelation19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19](s: String) = new TypedRelation19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19] {
    override val optName = Some(s)
  }
  def multi19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19](_))
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20] = new TypedRelation20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20](s: String) = new TypedRelation20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20] {
    override val optName = Some(s)
  }
  def multi20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20](_))
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21] = new TypedRelation21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21](s: String) = new TypedRelation21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21] {
    override val optName = Some(s)
  }
  def multi21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21](_))
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22] = new TypedRelation22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22](s: String) = new TypedRelation22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22] {
    override val optName = Some(s)
  }
  def multi22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22](ss: String*) = ss.map(apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22](_))
}
