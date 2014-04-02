/*******************************************************************************
 * Copyright (c) 2013 Bowen Cai.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Bowen Cai - initial API and implementation
 ******************************************************************************/
package com.baicai.awake.sql;

/**
 * 
 * @author BowenCai
 *
 */
public final class SQLQuery extends BaseBuilder {

//-------------------------------------------------------
//					with
//-------------------------------------------------------
		public SQLQuery 
		with(final String s) {
			builder.append(" SELECT ").append(s);
			return this;
		}
//-----------------------------------------------------------------------------
//					select
//-----------------------------------------------------------------------------
		public SQLQuery 
		selectFrom(final String s) {
			builder.append(" SELECT * FROM "  + s);
			return this;
		}
		public SQLQuery 
		select(final String s) {
			builder.append(" SELECT ").append(s);
			return this;
		}

		public SQLQuery 
		selectCount() {
			builder.append(" SELECT COUNT(1) ");
			return this;
		}
		public SQLQuery 
		selectCount(final String s) {
			builder.append(" SELECT COUNT(").append(s).append(")");
			return this;
		}
		public SQLQuery 
		selectMax(String s) {
			builder.append(" SELECT MAX(").append(s).append(")");
			return this;
		}
		public SQLQuery 
		selectMin(String s) {
			builder.append(" SELECT MIN(").append(s).append(")");
			return this;
		}
//-----------------------------------------------------------------------------
//					from clause
//----------------------------------------------------------------------------
		public SQLQuery 
		from(final String s) {
			builder.append(" FROM ").append(s);
			return this;
		}
		
		public SQLQuery 
		join(final String s) {
			builder.append(" JOIN ").append(s);
			return this;
		}
		public SQLQuery 
		leftJoin(final String s) {
			builder.append(" LEFT JOIN ").append(s);
			return this;
		}
		public SQLQuery 
		rightJoin(final String s) {
			builder.append(" RIGHT JOIN ").append(s);
			return this;
		}
		public SQLQuery 
		innerJoin(final String s) {
			builder.append(" INNER JOIN ").append(s);
			return this;
		}
		public SQLQuery 
		natureJoin(final String s) {
			builder.append(" NATURE JOIN ").append(s);
			return this;
		}
		public SQLQuery 
		on(final String s) {
			builder.append(" ON ").append(s);
			return this;
		}
//-----------------------------------------------------------------------------
//					where clause
//----------------------------------------------------------------------------
		public SQLQuery 
		where(final String s) {
			builder.append(" WHERE ").append(s);
			return this;
		}

		public<E> SQLQuery
		var(E a) {
			builder.append(" ? ");
			parameters.add(a);
			return this;
		}
		public SQLQuery 
		eq(final String n) {
			builder.append(" = ").append(n);
			return this;
		}
		
		public<E> SQLQuery 
		eq(E n) {
			builder.append(" = ? ");
			parameters.add(n);
			return this;
		}
		
		public SQLQuery 
		neq(final String n) {
			builder.append(n);
			return this;
		}
		public<E> SQLQuery 
		neq(E n) {
			builder.append(" != ?").append(n);
			parameters.add(n);
			return this;
		}
		public SQLQuery 
		greaterThan(final String n) {
			builder.append(n);
			return this;
		}
		public<E> SQLQuery 
		greaterThan(E n) {
			builder.append(" > ?");
			parameters.add(n);
			return this;
		}
		public SQLQuery 
		lessThan(final String n) {
				builder.append(n);
			return this;
		}
		public<E> SQLQuery 
		lessThan(E n) {
			builder.append(" < ?").append(n);
			parameters.add(n);
			return this;
		}
		public SQLQuery 
		between(final String n) {
			builder.append(n);
			return this;
		}
		public<E> SQLQuery 
		between(E n, E m) {
			builder.append(" BETWEEN ? and ? ");
			parameters.add(n);
			parameters.add(m);
			return this;
		}

		public SQLQuery 
		and(final String a) {
			builder.append(" AND ").append(a);
			return this;
		}
		
		public SQLQuery 
		or(final String a) {
			builder.append(" OR ").append(a);
			return this;
		}
//-----------------------------------------------------------------------------
//		where clause
//----------------------------------------------------------------------------
		public SQLQuery 
		in(final String s) {
			builder.append(" IN(").append(s).append(')');
			return this;
		}
		public SQLQuery 
		notIn(final String s) {
			builder.append(" NOT IN(").append(s).append(')');
			return this;
		}

//		public SQLQuery 
//		in(final String... s) {
//			builder.append(" IN (");
//			for (String string : s) {
//				builder.append(quote(string)).append(',');
//			}
//			builder.setCharAt(builder.lastIndexOf(","), ')');
//			return this;
//		}
//		public SQLQuery 
//		notIn(final String... s) {
//			builder.append(" NOT IN (");
//			for (String string : s) {
//				builder.append(quote(string)).append(',');
//			}
//			builder.setCharAt(builder.lastIndexOf(","), ')');
//			return this;
//		}

//-----------------------------------------------------------------------------
//		where clause
//----------------------------------------------------------------------------

//-----------------------------------------------------------------------------
//		where clause
//----------------------------------------------------------------------------
		public SQLQuery 
		in(final SQLQuery q) {
			builder.append(" IN(").append(q.builder).append(')');
			parameters.addAll(q.parameters);
			q.reset();
			return this;
		}
		
		public SQLQuery 
		notIn(final SQLQuery q) {
			builder.append(" NOT IN(").append(q.builder).append(')');
			parameters.addAll(q.parameters);
			q.reset();
			return this;
		}
//-----------------------------------------------------------------------------
//					having 
//----------------------------------------------------------------------------
		public SQLQuery 
		having(final String s) {
			builder.append(" HAVING ").append(s);
			return this;
		}
		
		public SQLQuery 
		groupBy(final String s) {
			builder.append(" GROUP BY ").append(s);
			return this;
		}
		
		public SQLQuery 
		orderBy(final String s) {
			builder.append(" ORDER BY ").append(s);
			return this;
		}
		
		public SQLQuery 
		offset(final int i) {
			builder.append(" OFFSET ").append(i);
			return this;
		}
		
		public SQLQuery 
		limit(final int i) {
			builder.append(" LIMIT ").append(i);
			return this;
		}

		@Override
		public 
		String toString() {
			return toSQL();
		}
		
		@Override
		public boolean 
		equals(Object o) {
			if (o == this) {
				return true;
			} else if (o instanceof SQLQuery) {
				SQLQuery oo = (SQLQuery)o;
				return oo.builder.equals(this.builder) 
						&& oo.parameters.equals(this.parameters);
			} else {
				return false;
			}
		}
		


}

//public<E extends Nu> SQLQuery 
//in(final List<E> ls) {
//	builder.append(" IN(");
//	
//	for (E string : ls) {
//		builder.append(string.toString()).append(',');
//	}
//	builder.setCharAt(builder.lastIndexOf(","), ')');
//	return this;
//}

//public <E> SQLQuery 
//notIn(final List<E> ls) {
//	builder.append(" NOT IN(");
//	
//	for (E string : ls) {
//		builder.append(string.toString()).append(',');
//	}
//	builder.setCharAt(builder.lastIndexOf(","), ')');
//	return this;
//}
//public SQLQuery 
//in(final List<String> ls) {
//	builder.append(" IN(");
//	
//	for (String string : ls) {
//		builder.append(quote(string)).append(',');
//	}
//	builder.setCharAt(builder.lastIndexOf(","), ')');
//	return this;
//}

//public <E> SQLQuery 
//notIn(final List<E> ls) {
//	builder.append(" NOT IN(");
//	
//	for (E string : ls) {
//		builder.append(string.toString()).append(',');
//	}
//	builder.setCharAt(builder.lastIndexOf(","), ')');
//	return this;
//}
